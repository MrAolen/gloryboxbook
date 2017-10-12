package fr.gunther.glorybox.website.entity;

import fr.gunther.glorybox.website.dto.AddressDTO;

import javax.persistence.*;

@Table
@Entity(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="postal")
    private String postal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public AddressDTO toDto() {
        AddressDTO address = new AddressDTO();
        address.setAddress(this.address);
        address.setCity(this.city);
        address.setCountry(this.country);
        address.setPostal(this.postal);
        return address;
    }
}
