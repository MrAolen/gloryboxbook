package fr.gunther.glorybox.website.entity;

import fr.gunther.glorybox.website.dto.BoxDTO;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name="box")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Float price;

    @Column(name="creationDate")
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BoxDTO toDto() {
        BoxDTO box = new BoxDTO();
        box.setCreationDate(this.creationDate);
        box.setName(this.name);
        box.setId(this.id);
        box.setPrice(this.price);
        return box;
    }
}
