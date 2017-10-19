package fr.gunther.glorybox.website.controller;

import fr.gunther.glorybox.website.dto.AjaxRequestDeleteDTO;
import fr.gunther.glorybox.website.dto.AjaxRequestDescriptionDTO;
import fr.gunther.glorybox.website.dto.AjaxRequestPriceDTO;
import fr.gunther.glorybox.website.dto.AjaxRequestStatusArchivedDTO;
import fr.gunther.glorybox.website.dto.AjaxRequestStatusValidateDTO;
import fr.gunther.glorybox.website.service.BoxService;
import fr.gunther.glorybox.website.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    @RequestMapping(value="/update/status/validate")
    public ResponseEntity<?> updateStatusToValidate(@RequestBody AjaxRequestStatusValidateDTO request) {
        commandService.updateStatusToValidate(Long.parseLong(request.getId()));
        return ResponseEntity.ok(request);
    }

    @ResponseBody
    @RequestMapping(value="/update/status/archived")
    public ResponseEntity<?> updateStatusToArchived(@RequestBody AjaxRequestStatusArchivedDTO request) {
        commandService.updateStatusToArchived(Long.parseLong(request.getId()), request.getLink());
        return ResponseEntity.ok(request);
    }

    @ResponseBody
    @RequestMapping(value="/delete")
    public ResponseEntity<?> deleteCommand(@RequestBody AjaxRequestDeleteDTO request) {
        commandService.deleteCommand(Long.parseLong(request.getId()));
        return ResponseEntity.ok(request);
    }
}
