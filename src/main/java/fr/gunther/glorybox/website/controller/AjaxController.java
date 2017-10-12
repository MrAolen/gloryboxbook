package fr.gunther.glorybox.website.controller;

import fr.gunther.glorybox.website.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// http://www.mkyong.com/spring-mvc/spring-4-mvc-ajax-hello-world-example/

@Controller
public class AjaxController {

    @Autowired
    private BoxService boxService;

    @ResponseBody
    @RequestMapping(value = "/update/description")
    public String getSearchResultViaAjax(@RequestBody String description) {



        return description;
    }
}
