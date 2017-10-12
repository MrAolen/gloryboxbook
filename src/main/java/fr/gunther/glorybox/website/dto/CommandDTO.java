package fr.gunther.glorybox.website.dto;

import javax.persistence.*;

public class CommandDTO {

    private Long id;
    private String email;
    private String name;
    private String forname;
    private AddressDTO delivryAddress;
    private AddressDTO billAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public AddressDTO getDelivryAddress() {
        return delivryAddress;
    }

    public void setDelivryAddress(AddressDTO delivryAddress) {
        this.delivryAddress = delivryAddress;
    }

    public AddressDTO getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(AddressDTO billAddress) {
        this.billAddress = billAddress;
    }
}

