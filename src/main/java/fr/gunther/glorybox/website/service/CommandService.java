package fr.gunther.glorybox.website.service;

import fr.gunther.glorybox.website.dto.FormCommandDTO;

public interface CommandService {

    boolean saveCommand(FormCommandDTO form);
}
