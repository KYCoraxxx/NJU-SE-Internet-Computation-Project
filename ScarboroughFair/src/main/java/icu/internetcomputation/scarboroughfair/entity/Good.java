package icu.internetcomputation.scarboroughfair.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "good")
public class Good {
    @Id
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
    @ElementCollection(targetClass=String.class)
    private List<String> picture;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String tag;

    @Getter
    @Setter
    private Integer click;

    @Getter
    @Setter
    private Integer userID;

    public Good(){
        this.id = -1;
        this.name = null;
        this.price = null;
        this.picture = null;
        this.description = null;
        this.cover = null;
        this.click=0;
        this.userID=0;
    }

    public Good(Integer id, String name, Float price, String cover, List<String> picture, String description, String tag,Integer userid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cover = cover;
        this.picture = picture;
        this.description = description;
        this.tag = tag;
        this.click=0;
        this.userID=userid;
    }

    public void addClick(){
        this.click++;
    }
    
}
