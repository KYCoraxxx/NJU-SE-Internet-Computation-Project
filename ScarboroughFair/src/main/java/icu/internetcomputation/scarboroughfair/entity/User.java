package icu.internetcomputation.scarboroughfair.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
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
    
    @Getter
    @Setter
    private String avatorUrl;
    public User(Integer id, String name, String password,String avatorUrl) 
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.avatorUrl = avatorUrl;
    }

    public User()
    {
        this.id = 0;
        this.name = "norman";
        this.password = "nopassword";
        this.avatorUrl = "noavator";
    }
}
