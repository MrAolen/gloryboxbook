package fr.gunther.glorybox.website.dto;

public class CountryDeliveryDTO {

        private Long id;
        private String country;
        private Float price;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public Float getPrice() {
                return price;
        }

        public void setPrice(Float price) {
                this.price = price;
        }
}
