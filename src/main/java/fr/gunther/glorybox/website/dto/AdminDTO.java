package fr.gunther.glorybox.website.dto;

import java.util.List;

public class AdminDTO {
    private List<CommandDTO> archiveCommands;
    private List<CommandDTO> validateCommands;
    private List<CommandDTO> pendingCommands;
    private String description;
    private Float price;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
