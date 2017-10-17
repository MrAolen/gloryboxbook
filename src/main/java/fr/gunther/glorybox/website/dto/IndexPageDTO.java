package fr.gunther.glorybox.website.dto;

public class IndexPageDTO {
    private String description;
    private String price;
    private FormCommandDTO form;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FormCommandDTO getForm() {
        return form;
    }

    public void setForm(FormCommandDTO form) {
        this.form = form;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
