package fr.gunther.glorybox.website.dto;

import java.util.List;

public class AdminDTO {
    private List<CommandDTO> commandsCurrent;

    public List<CommandDTO> getCommandsCurrent() {
        return commandsCurrent;
    }

    public void setCommandsCurrent(List<CommandDTO> commandsCurrent) {
        this.commandsCurrent = commandsCurrent;
    }
}
