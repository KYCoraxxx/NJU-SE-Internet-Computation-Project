package icu.internetcomputation.scarboroughfair.entity;

import lombok.Getter;

public class Data {

    @Getter
    public int userID;

    @Getter
    public String userName;

    @Getter
    public String avator;

    public Data(int userID, String userName, String avator){
        this.userID = userID;
        this.userName = userName;
        this.avator = avator;
    }
}
