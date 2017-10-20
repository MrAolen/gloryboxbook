package fr.gunther.glorybox.website.service;

import fr.gunther.glorybox.website.dto.BoxDTO;

import java.util.List;

public interface BoxService {

        boolean updatePrice(String price);
        Float getPriceBox();
        List<BoxDTO> getAvailableBoxes();
}
