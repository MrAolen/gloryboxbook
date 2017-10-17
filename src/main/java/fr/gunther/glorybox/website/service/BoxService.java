package fr.gunther.glorybox.website.service;

public interface BoxService {

        boolean updateDescription(String description);
        boolean updatePrice(String price);
        String getDescriptionBox();

    Float getPriceBox();
}
