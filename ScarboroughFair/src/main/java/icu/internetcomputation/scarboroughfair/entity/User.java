package icu.internetcomputation.scarboroughfair.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
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
    private String password;
    
    public User(Integer id, String name, String password) 
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    User()
    {
        this.id = null;
        this.name = null;
        this.password = null;
    }
}
