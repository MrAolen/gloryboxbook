package fr.gunther.glorybox.website.entity;

import fr.gunther.glorybox.website.dto.CountryDeliveryDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country_delivery")
public class CountryDelivery {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id")
        private Long id;

        @Column(name="price")
        private Float price;

        @Column(name="country")
        private String country;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Float getPrice() {
                return price;
        }

        public void setPrice(Float price) {
                this.price = price;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public CountryDeliveryDTO toDto() {
                CountryDeliveryDTO countryDeliveryDTO = new CountryDeliveryDTO();
                countryDeliveryDTO.setCountry(this.country);
                countryDeliveryDTO.setId(this.id);
                countryDeliveryDTO.setPrice(this.price);
                return countryDeliveryDTO;
        }
}
