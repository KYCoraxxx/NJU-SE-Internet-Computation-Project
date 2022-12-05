package icu.internetcomputation.scarboroughfair.entity;
import lombok.Getter;
import lombok.Setter;
public class dropDown {
    @Getter
    @Setter
    String userName;

    @Getter
    @Setter
    int userId;

    @Getter
    @Setter
    String avatorUrl;
    
    public dropDown(String name,int id,String avator)
    {
        this.userName=name;
        this.userId=id;
        this.avatorUrl=avator;
    }
    public dropDown(){
        this.userName="norman";
        this.userId=0;
        this.avatorUrl="noavator";
    }
}
