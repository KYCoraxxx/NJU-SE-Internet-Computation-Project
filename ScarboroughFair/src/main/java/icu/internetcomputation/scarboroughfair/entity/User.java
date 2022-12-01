package icu.internetcomputation.scarboroughfair.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
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

    public User()
    {
        this.id = null;
        this.name = null;
        this.password = null;
    }
}
