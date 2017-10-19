package fr.gunther.glorybox.website.entity;

import fr.gunther.glorybox.website.dto.CommandDTO;

import javax.persistence.*;

@Table
@Entity(name="command")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name="forname")
    private String forname;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="link")
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public CommandDTO toDto() {
        CommandDTO command = new CommandDTO();
        command.setEmail(this.email);
        command.setForname(this.forname);
        command.setName(this.name);
        command.setAddress(this.address.toDto());
        command.setId(this.id);
        command.setStatus(this.status);
        command.setLink(this.link);
        return command;
    }

    public enum Status {
        PENDING, VALIDATE, ARCHIVED
    }
}

