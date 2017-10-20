package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.dto.AdminDTO;
import fr.gunther.glorybox.website.entity.Box;
import fr.gunther.glorybox.website.repository.BoxRepository;
import fr.gunther.glorybox.website.service.AdminService;
import fr.gunther.glorybox.website.service.BoxService;
import fr.gunther.glorybox.website.service.CommandService;
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

    @Override
    public AdminDTO getAdminDatas() {
        AdminDTO admin = new AdminDTO();
        admin.setArchiveCommands(commandService.findAllOldCommand());
        admin.setPendingCommands(commandService.findAllPendingCommand());
        admin.setValidateCommands(commandService.findAllValidateCommand());
        admin.setBoxes(boxService.getAvailableBoxes());
        admin.setDescription(staticDataService.getValueByKey("description"));
        return admin;
    }
}
