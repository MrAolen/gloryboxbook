package fr.gunther.glorybox.website.dto;

import fr.gunther.glorybox.website.entity.Command;

import java.util.Date;

public class CommandDTO {

    private Long id;
    private String email;
    private String name;
    private String forname;
    private String link;
    private AddressDTO address;
    private Command.Status status;
    private Date creationDate;
    private BoxDTO box;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BoxDTO getBox() {
        return box;
    }

    public void setBox(BoxDTO box) {
        this.box = box;
    }

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

    public Command.Status getStatus() {
        return status;
    }

    public void setStatus(Command.Status status) {
        this.status = status;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

