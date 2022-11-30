package icu.internetcomputation.scarboroughfair.entity;

public class Message {
    public boolean isSucceed = false;
    public String message = null;

    public Message(boolean isSucceed , String message) 
    {
        this.isSucceed = isSucceed;
        this.message = message;
    }
        
}
