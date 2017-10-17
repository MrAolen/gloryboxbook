package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.dto.CommandDTO;
import fr.gunther.glorybox.website.dto.FormCommandDTO;
import fr.gunther.glorybox.website.entity.Address;
import fr.gunther.glorybox.website.entity.Command;
import fr.gunther.glorybox.website.entity.Command.Status;
import fr.gunther.glorybox.website.repository.AddressRepository;
import fr.gunther.glorybox.website.repository.CommandRepository;
import fr.gunther.glorybox.website.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        newCommand.setStatus(Command.Status.PENDING);

        newCommand = commandRepository.save(newCommand);
        return newCommand != null;
    }

    @Override
    public List<CommandDTO> findAllPendingCommand() {
        return commandRepository.findByStatus(Command.Status.PENDING).stream().map(x -> x.toDto()).collect(Collectors.toList());
    }

    @Override
    public List<CommandDTO> findAllOldCommand() {
        return commandRepository.findByStatus(Command.Status.ARCHIVED).stream().map(x -> x.toDto()).collect(Collectors.toList());
    }

    @Override
    public List<CommandDTO> findAllValidateCommand() {
        return commandRepository.findByStatus(Command.Status.VALIDATE).stream().map(x -> x.toDto()).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(Status status, Long id) {
        Command commandToUpdate = commandRepository.findOne(id);
        commandToUpdate.setStatus(status);
        commandRepository.save(commandToUpdate);
    }
}
