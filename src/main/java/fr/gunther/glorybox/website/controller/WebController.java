package fr.gunther.glorybox.website.controller;

import fr.gunther.glorybox.website.dto.FormCommandDTO;
import fr.gunther.glorybox.website.dto.IndexPageDTO;
import fr.gunther.glorybox.website.service.BoxService;
import fr.gunther.glorybox.website.service.CommandService;
import fr.gunther.glorybox.website.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

        @Autowired
        private CommandService commandService;

        @Autowired
        private EmailService emailService;

        @Autowired
        private BoxService boxService;

        @GetMapping("/")
        public ModelAndView displayMainPage() {
                String description = boxService.getDescriptionBox();
                Float price = boxService.getPriceBox();
                IndexPageDTO info = new IndexPageDTO();
                info.setDescription(description);
                info.setPrice(price.toString() + " €");
                return new ModelAndView("index","info", info);
        }

        @PostMapping("/command")
        public ModelAndView postCommand(@ModelAttribute("commandForm") FormCommandDTO commandForm) {
                commandService.saveCommand(commandForm);
                emailService.sendCommandConfirmation(commandForm.getEmail(), commandForm.getName(), commandForm.getForname());
                return new ModelAndView("redirect:/");
        }
}
