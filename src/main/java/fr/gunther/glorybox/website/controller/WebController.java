package fr.gunther.glorybox.website.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import fr.gunther.glorybox.website.configuration.PaypalPaymentIntent;
import fr.gunther.glorybox.website.configuration.PaypalPaymentMethod;
import fr.gunther.glorybox.website.dto.CommandDTO;
import fr.gunther.glorybox.website.dto.FormCommandDTO;
import fr.gunther.glorybox.website.service.BoxService;
import fr.gunther.glorybox.website.service.CommandService;
import fr.gunther.glorybox.website.service.CountryDeliveryService;
import fr.gunther.glorybox.website.service.EmailService;
import fr.gunther.glorybox.website.service.PayPalService;
import fr.gunther.glorybox.website.service.StaticDataService;
import fr.gunther.glorybox.website.util.URLUtils;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

        @Autowired
        private CommandService commandService;

        @Autowired
        private EmailService emailService;

        @Autowired
        private BoxService boxService;

        @Autowired
        private StaticDataService staticDataService;

        @Autowired
        private PayPalService paypalService;

        @Autowired
        private CountryDeliveryService countryDeliveryService;

        private Logger log = LoggerFactory.getLogger(getClass());

        @GetMapping("/")
        public String displayMainPage(Model model,@ModelAttribute("error") String error, @ModelAttribute("info") String info) {
                String description = staticDataService.getValueByKey("description");
                model.addAttribute("description",description);
                model.addAttribute("form",new FormCommandDTO());
                model.addAttribute("boxes",boxService.getAvailableBoxes());
                model.addAttribute("countries", countryDeliveryService.getAllCountryDelivery());
                model.addAttribute("error",error);
                model.addAttribute("info",info);
                return "index";
        }

        @PostMapping("/command")
        public String postCommand(HttpServletRequest request, @ModelAttribute("commandForm") FormCommandDTO commandForm) {
                Long idcommand = commandService.saveCommand(commandForm);

                String cancelUrl = URLUtils.getBaseURl(request)  + "/pay/cancel";
                String successUrl = URLUtils.getBaseURl(request) + "/pay/success";
                try {
                        Payment payment = paypalService.createPayment(getTotalPrice(commandForm),"EUR", PaypalPaymentMethod.paypal,
                                PaypalPaymentIntent.sale,"Payment Glory Book Box - " + commandForm.getName() + " - " + commandForm.getForname(),cancelUrl,successUrl,idcommand);
                        for(Links links : payment.getLinks()){
                                if(links.getRel().equals("approval_url")){
                                        return "redirect:" + links.getHref();
                                }
                        }
                } catch (PayPalRESTException e) {
                        log.error(e.getMessage());
                }
                return "redirect:/";
        }


        @GetMapping("/pay/cancel")
        public String cancelPay(@RequestParam("idcommand") Long idcommand){
                commandService.deleteCommand(idcommand);
                return "cancel";
        }

        @GetMapping("/pay/success")
        public String successPay(RedirectAttributes redir, @RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, @RequestParam("idcommand") Long idcommand){
                CommandDTO command = commandService.getDetailCommand(idcommand);

                try {
                        Payment payment = paypalService.executePayment(paymentId, payerId);
                        if(payment.getState().equals("approved")){
                                emailService.sendCommandConfirmation(command.getEmail(), command.getName(), command.getForname());
                                redir.addFlashAttribute("info", "Votre commande a bien été prise en compte, allez regarder vos mails.");
                                return "redirect:/";
                        }
                } catch (PayPalRESTException e) {
                        log.error(e.getMessage());
                        redir.addFlashAttribute("error", "Erreur lors du paiement veuillez réessayer ou contacter l'administrateur.");
                        return "redirect:/";
                }
                redir.addFlashAttribute("error", "Erreur lors du paiement veuillez réessayer ou contacter l'administrateur.");
                return "redirect:/";        }

        private Float getTotalPrice(FormCommandDTO form) {
                return boxService.getPriceBox(Long.parseLong(form.getBox())) + countryDeliveryService.getPriceByCountryId(Long.parseLong(form.getCountry()));
        }
}
