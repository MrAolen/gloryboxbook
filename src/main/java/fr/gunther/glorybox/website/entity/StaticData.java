package fr.gunther.glorybox.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity(name="box")
public class StaticData {
        @Column(name="label")
        private String label;

        @Column(name="key")
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
}
