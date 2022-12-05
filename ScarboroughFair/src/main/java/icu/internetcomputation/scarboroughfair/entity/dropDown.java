package icu.internetcomputation.scarboroughfair.entity;

public class dropDown {
    String userName;
    int userId;
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
