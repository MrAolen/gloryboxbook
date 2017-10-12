package fr.gunther.glorybox.website.dto;

import java.util.List;

public class AdminDTO {
    private List<CommandDTO> archiveCommands;
    private List<CommandDTO> validateCommands;
    private List<CommandDTO> pendingCommands;

    public List<CommandDTO> getArchiveCommands() {
        return archiveCommands;
    }

    public void setArchiveCommands(List<CommandDTO> archiveCommands) {
        this.archiveCommands = archiveCommands;
    }

    public List<CommandDTO> getValidateCommands() {
        return validateCommands;
    }

    public void setValidateCommands(List<CommandDTO> validateCommands) {
        this.validateCommands = validateCommands;
    }

    public List<CommandDTO> getPendingCommands() {
        return pendingCommands;
    }

    public void setPendingCommands(List<CommandDTO> pendingCommands) {
        this.pendingCommands = pendingCommands;
    }
}
