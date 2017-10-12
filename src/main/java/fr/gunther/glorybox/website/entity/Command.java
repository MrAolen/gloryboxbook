package fr.gunther.glorybox.website.entity;

import javax.persistence.*;

@Table
@Entity(name="command")
public class Command {
    @Id
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name="forname")
    private String forname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_delivery_address")
    private Address delivryAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_bill_address")
    private Address billAddress;

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

    public Address getDelivryAddress() {
        return delivryAddress;
    }

    public void setDelivryAddress(Address delivryAddress) {
        this.delivryAddress = delivryAddress;
    }

    public Address getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
    }
}

