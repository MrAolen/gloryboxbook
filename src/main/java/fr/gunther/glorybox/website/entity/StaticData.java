package fr.gunther.glorybox.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="static_datas_website")
public class StaticData {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id")
        private Long id;

        @Column(name="value_staticdata")
        private String label;

        @Column(name="key_staticdata")
        private String key;

        public String getLabel() {
                return label;
        }

        public void setLabel(String label) {
                this.label = label;
        }

        public String getKey() {
                return key;
        }

        public void setKey(String key) {
                this.key = key;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }
}
