package fr.gunther.glorybox.website.dto;

import java.util.List;

public class AdminDTO {
    private List<CommandDTO> archiveCommands;
    private List<CommandDTO> validateCommands;
    private List<CommandDTO> pendingCommands;
    private String description;
    private List<BoxDTO> boxes;
    private Float priceFrance;
    private Float priceCanada;
    private Float priceLuxembourg;
    private Float priceOutreMer;
    private Float priceBelgique;

    public Float getPriceFrance() {
        return priceFrance;
    }

    public void setPriceFrance(Float priceFrance) {
        this.priceFrance = priceFrance;
    }

    public Float getPriceCanada() {
        return priceCanada;
    }

    public void setPriceCanada(Float priceCanada) {
        this.priceCanada = priceCanada;
    }

    public Float getPriceLuxembourg() {
        return priceLuxembourg;
    }

    public void setPriceLuxembourg(Float priceLuxembourg) {
        this.priceLuxembourg = priceLuxembourg;
    }

    public Float getPriceOutreMer() {
        return priceOutreMer;
    }

    public void setPriceOutreMer(Float priceOutreMer) {
        this.priceOutreMer = priceOutreMer;
    }

    public Float getPriceBelgique() {
        return priceBelgique;
    }

    public void setPriceBelgique(Float priceBelgique) {
        this.priceBelgique = priceBelgique;
    }

    public List<BoxDTO> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<BoxDTO> boxes) {
        this.boxes = boxes;
    }

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
}
