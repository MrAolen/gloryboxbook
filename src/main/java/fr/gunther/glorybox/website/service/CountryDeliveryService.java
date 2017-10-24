package fr.gunther.glorybox.website.service;

import fr.gunther.glorybox.website.dto.CountryDeliveryDTO;
import java.util.List;

public interface CountryDeliveryService {
        List<CountryDeliveryDTO> getAllCountryDelivery();

        String findById(Long id);

        Float getPriceByCountryId(Long id);

        void updatePrice(Float price, Long idcountry);
}
