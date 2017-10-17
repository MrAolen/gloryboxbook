package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.entity.Box;
import fr.gunther.glorybox.website.repository.BoxRepository;
import fr.gunther.glorybox.website.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoxServiceImpl implements BoxService {

        @Autowired
        private BoxRepository boxRepository;

        @Override
        public boolean updateDescription(String description) {
                Box box = boxRepository.findFirstByOrderByCreationDateDesc();
                box.setDescription(description);
                boxRepository.save(box);
                return true;
        }

        @Override
        public boolean updatePrice(String price) {
                Box box = boxRepository.findFirstByOrderByCreationDateDesc();
                box.setPrice(Float.parseFloat(price));
                boxRepository.save(box);
                return true;
        }

        @Override
        public String getDescriptionBox() {
                Box box = boxRepository.findFirstByOrderByCreationDateDesc();
                return box.getDescription();
        }

    @Override
    public Float getPriceBox() {
        Box box = boxRepository.findFirstByOrderByCreationDateDesc();
        return box.getPrice();
    }
}
