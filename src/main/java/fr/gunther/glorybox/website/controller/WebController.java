package fr.gunther.glorybox.website.controller;

import fr.gunther.glorybox.website.dto.BoxDTO;
import fr.gunther.glorybox.website.dto.FormCommandDTO;
import fr.gunther.glorybox.website.dto.IndexPageDTO;
import fr.gunther.glorybox.website.service.BoxService;
import fr.gunther.glorybox.website.service.CommandService;
import fr.gunther.glorybox.website.service.EmailService;
import fr.gunther.glorybox.website.service.StaticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

        @GetMapping("/")
        public String displayMainPage(Model model) {
                String description = staticDataService.getValueByKey("description");

                model.addAttribute("description",description);
                model.addAttribute("form",new FormCommandDTO());
                model.addAttribute("boxes",boxService.getAvailableBoxes());
                return "index";
        }

        @PostMapping("/command")
        public ModelAndView postCommand(@ModelAttribute("commandForm") FormCommandDTO commandForm) {
                commandService.saveCommand(commandForm);
                emailService.sendCommandConfirmation(commandForm.getEmail(), commandForm.getName(), commandForm.getForname());
                return new ModelAndView("redirect:/");
        }
}
