package fr.gunther.glorybox.website.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import fr.gunther.glorybox.website.configuration.PaypalPaymentIntent;
import fr.gunther.glorybox.website.configuration.PaypalPaymentMethod;
import fr.gunther.glorybox.website.dto.FormCommandDTO;
import fr.gunther.glorybox.website.service.EmailService;
import fr.gunther.glorybox.website.service.PayPalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fr.gunther.glorybox.website.util.URLUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

// https://github.com/masasdani/paypal-springboot/tree/master/src/main/resources/templates

@Controller
public class PaymentController {

    public static final String PAYPAL_SUCCESS_URL = "/pay/success";
    public static final String PAYPAL_CANCEL_URL = "/pay/cancel";

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PayPalService paypalService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/mail")
    public ModelAndView textMail() {
        //emailService.prepareAndSend("gunthernic@eisti.eu","gunthernic@eisti.eu","mail",new HashMap<>(),"mail-command-confirmation");
        return new ModelAndView("index","commandForm", new FormCommandDTO());
    }

    @GetMapping("/test")
    public String index(){
        return "test";
    }

    @PostMapping(value = "/pay")
    public String pay(HttpServletRequest request){
        String cancelUrl = URLUtils.getBaseURl(request)  + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + PAYPAL_SUCCESS_URL;
        try {
            Payment payment = paypalService.createPayment(4D,"EUR",PaypalPaymentMethod.paypal,PaypalPaymentIntent.sale,"payment description",cancelUrl,successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/test";
    }

    @GetMapping("/pay/cancel")
    public String cancelPay(){
        return "cancel";
    }

    @GetMapping("/pay/success")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                return "success";
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

}