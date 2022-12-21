package icu.internetcomputation.scarboroughfair.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "good")
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
    private String cover;

    @Getter
    @Setter
    private String[] picture;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String tag;

    public Good(){
        this.id = -1;
        this.name = null;
        this.price = null;
        this.picture = null;
        this.description = null;
        this.cover = null;

    }

    public Good(Integer id, String name, Float price, String cover, String[] picture, String description, String tag) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cover = cover;
        this.picture = picture;
        this.description = description;
        this.tag = tag;
    }
    
}
