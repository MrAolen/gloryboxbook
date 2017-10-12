package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.dto.FormCommandDTO;
import fr.gunther.glorybox.website.entity.Address;
import fr.gunther.glorybox.website.entity.Command;
import fr.gunther.glorybox.website.repository.CommandRepository;
import fr.gunther.glorybox.website.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    private CommandRepository commandRepository;

    @Override
    public boolean saveCommand(FormCommandDTO form) {
        Address billAddress = new Address();
        billAddress.setAddress(form.getBill_address());
        billAddress.setCity(form.getBill_city());
        billAddress.setCountry(form.getBill_country());

        Address deliveryAddress = new Address();
        deliveryAddress.setCountry(form.getDelivry_country());
        deliveryAddress.setCity(form.getDelivry_city());
        deliveryAddress.setAddress(form.getDelivry_address());

        Command newCommand = new Command();
        newCommand.setEmail(form.getEmail());
        newCommand.setForname(form.getForname());
        newCommand.setName(form.getName());
        newCommand.setBillAddress(billAddress);
        newCommand.setDelivryAddress(deliveryAddress);

        newCommand = commandRepository.save(newCommand);
        return newCommand != null;
    }
}
