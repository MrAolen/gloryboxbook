package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.dto.CommandDTO;
import fr.gunther.glorybox.website.dto.FormCommandDTO;
import fr.gunther.glorybox.website.entity.Address;
import fr.gunther.glorybox.website.entity.Command;
import fr.gunther.glorybox.website.repository.AddressRepository;
import fr.gunther.glorybox.website.repository.CommandRepository;
import fr.gunther.glorybox.website.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public boolean saveCommand(FormCommandDTO form) {
        Address address = new Address();
        address.setAddress(form.getAddress());
        address.setCity(form.getCity());
        address.setCountry(form.getCountry());
        Address newAddress = addressRepository.save(address);

        Command newCommand = new Command();
        newCommand.setEmail(form.getEmail());
        newCommand.setForname(form.getForname());
        newCommand.setName(form.getName());
        newCommand.setAddress(newAddress);

        newCommand = commandRepository.save(newCommand);
        return newCommand != null;
    }

    @Override
    public List<CommandDTO> findAllCurrentCommand() {
        return commandRepository.findAll().stream().map(x -> x.toDto()).collect(Collectors.toList());
    }
}
