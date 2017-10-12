package fr.gunther.glorybox.website.controller;

import fr.gunther.glorybox.website.dto.FormCommandDTO;
import fr.gunther.glorybox.website.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

        @Autowired
        private CommandService commandService;

        @GetMapping("/")
        public ModelAndView displayMainPage() {
                return new ModelAndView("index");
        }

        @PostMapping("/")
        public ModelAndView postCommand(@ModelAttribute FormCommandDTO form) {
                return new ModelAndView("index", "validationCommand", "sucess");
        }
}
