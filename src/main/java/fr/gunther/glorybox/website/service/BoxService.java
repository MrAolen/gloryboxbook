package fr.gunther.glorybox.website.service;

import fr.gunther.glorybox.website.dto.BoxDTO;

import java.util.Date;
import java.util.List;

public interface BoxService {
    boolean updatePrice(String price);
    Float getPriceBox();
    List<BoxDTO> getAvailableBoxes();
    BoxDTO createBox(String name, String price, Date creationDate);

    void deleteBox(String id);
}
