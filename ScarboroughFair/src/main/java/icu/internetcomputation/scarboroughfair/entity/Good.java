package icu.internetcomputation.scarboroughfair.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Float price;

    @Getter
    @Setter
    private String picture;

    Good(){
        this.id = null;
        this.name = null;
        this.price = null;
        this.picture = null;
    }
    
}
