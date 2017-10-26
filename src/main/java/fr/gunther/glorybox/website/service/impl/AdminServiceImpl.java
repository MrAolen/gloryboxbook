package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.dto.AdminDTO;
import fr.gunther.glorybox.website.entity.Box;
import fr.gunther.glorybox.website.repository.BoxRepository;
import fr.gunther.glorybox.website.repository.CountryDeliveryRepository;
import fr.gunther.glorybox.website.service.AdminService;
import fr.gunther.glorybox.website.service.BoxService;
import fr.gunther.glorybox.website.service.CommandService;
import fr.gunther.glorybox.website.service.CountryDeliveryService;
import fr.gunther.glorybox.website.service.StaticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CommandService commandService;

    @Autowired
    private BoxService boxService;

    @Autowired
    private StaticDataService staticDataService;

    @Autowired
    private CountryDeliveryRepository countryDeliveryRepository;

    @Override
    public AdminDTO getAdminDatas() {
        AdminDTO admin = new AdminDTO();
        admin.setArchiveCommands(commandService.findAllOldCommand());
        admin.setPendingCommands(commandService.findAllPendingCommand());
        admin.setValidateCommands(commandService.findAllValidateCommand());
        admin.setBoxes(boxService.getAvailableBoxes());
        admin.setDescription(staticDataService.getValueByKey("description"));
        /*admin.setPriceBelgique(countryDeliveryRepository.findOne((long) 4).getPrice());
        admin.setPriceCanada(countryDeliveryRepository.findOne((long) 3).getPrice());
        admin.setPriceFrance(countryDeliveryRepository.findOne((long) 1).getPrice());
        admin.setPriceLuxembourg(countryDeliveryRepository.findOne((long) 5).getPrice());
        admin.setPriceOutreMer(countryDeliveryRepository.findOne((long) 2).getPrice());*/
        return admin;
    }
}
