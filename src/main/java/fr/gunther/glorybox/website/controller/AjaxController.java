package fr.gunther.glorybox.website.controller;

import fr.gunther.glorybox.website.dto.AjaxRequestDeleteDTO;
import fr.gunther.glorybox.website.dto.AjaxRequestDescriptionDTO;
import fr.gunther.glorybox.website.dto.AjaxRequestPriceDTO;
import fr.gunther.glorybox.website.dto.AjaxRequestStatusDTO;
import fr.gunther.glorybox.website.entity.Command;
import fr.gunther.glorybox.website.entity.Command.Status;
import fr.gunther.glorybox.website.service.BoxService;
import fr.gunther.glorybox.website.service.CommandService;
import fr.gunther.glorybox.website.service.EmailService;
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

    @Autowired
    private CommandService commandService;

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

    @ResponseBody
    @RequestMapping(value="/update/status")
    public ResponseEntity<?> updateStatus(@RequestBody AjaxRequestStatusDTO request) {
        if (request.getStatus().equals("validate")) {
            commandService.updateStatus(Status.VALIDATE, Long.parseLong(request.getId()));
        }
        if (request.getStatus().equals("archived")) {
            commandService.updateStatus(Status.ARCHIVED, Long.parseLong(request.getId()));
        }
        return ResponseEntity.ok(request);
    }

    @ResponseBody
    @RequestMapping(value="/delete")
    public ResponseEntity<?> deleteCommand(@RequestBody AjaxRequestDeleteDTO request) {
        commandService.deleteCommand(Long.parseLong(request.getId()));
        return ResponseEntity.ok(request);
    }
}
