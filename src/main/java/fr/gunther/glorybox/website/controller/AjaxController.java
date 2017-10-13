package fr.gunther.glorybox.website.controller;

import fr.gunther.glorybox.website.dto.AjaxRequestDescriptionDTO;
import fr.gunther.glorybox.website.dto.AjaxRequestPriceDTO;
import fr.gunther.glorybox.website.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

    @Autowired
    private BoxService boxService;

    @ResponseBody
    @RequestMapping(value = "/update/description")
    public ResponseEntity<?> updateDescriptionBox(@RequestBody AjaxRequestDescriptionDTO request) {
        boxService.updateDescription(request.getDescription());
        return ResponseEntity.ok(request);
    }

    @ResponseBody
    @RequestMapping(value = "/update/price")
    public ResponseEntity<?> updatePriceBox(@RequestBody AjaxRequestPriceDTO request) {
        boxService.updatePrice(request.getPrice());
        return ResponseEntity.ok(request);
    }
}
