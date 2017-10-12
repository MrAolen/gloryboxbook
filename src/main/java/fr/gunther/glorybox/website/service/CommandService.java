package fr.gunther.glorybox.website.service;

import fr.gunther.glorybox.website.dto.CommandDTO;
import fr.gunther.glorybox.website.dto.FormCommandDTO;

import java.util.List;

public interface CommandService {

    boolean saveCommand(FormCommandDTO form);

    List<CommandDTO> findAllCurrentCommand();
}
