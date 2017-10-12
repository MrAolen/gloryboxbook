package fr.gunther.glorybox.website.controller;

import fr.gunther.glorybox.website.entity.User;
import fr.gunther.glorybox.website.service.SecurityService;
import fr.gunther.glorybox.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/login-admin")
    public ModelAndView displayLoginAdminPage(Model model) {
        return new ModelAndView("login-admin","userForm",new User());
    }

    @GetMapping("/admin")
    public ModelAndView displayAdminPage() {
        return new ModelAndView("admin");
    }

    @GetMapping("/admin/detail/{idcommand}")
    public ModelAndView displayDetailPageCommand(@PathVariable("idcommand") Long idCommand) {
        return new ModelAndView("detail");
    }
}
