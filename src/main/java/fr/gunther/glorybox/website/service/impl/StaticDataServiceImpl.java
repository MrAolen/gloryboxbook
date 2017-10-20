package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.entity.StaticData;
import fr.gunther.glorybox.website.repository.StaticDataRepository;
import fr.gunther.glorybox.website.service.StaticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaticDataServiceImpl implements StaticDataService {

    @Autowired
    private StaticDataRepository staticDataRepository;

    @Override
    public String getValueByKey(String key) {
        return staticDataRepository.findByKey(key).getLabel();
    }

    @Override
    public void updateByKey(String key, String value) {
        StaticData staticData = staticDataRepository.findByKey(key);
        staticData.setLabel(value);
        staticDataRepository.save(staticData);
    }
}
