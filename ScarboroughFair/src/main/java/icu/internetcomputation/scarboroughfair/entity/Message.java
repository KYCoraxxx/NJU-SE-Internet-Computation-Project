package icu.internetcomputation.scarboroughfair.entity;

public class Message {
    public boolean isSucceed = false;
    public String message = null;
    public String url = null;
    public int id = 0;
    public Message(boolean isSucceed , String message) 
    {
        this.isSucceed = isSucceed;
        this.message = message;
        this.url=null;
        this.id=0;
    }
    public Message(boolean isSucceed , String message, String url) 
    {
        this.isSucceed = isSucceed;
        this.message = message;
        this.url=url;
        this.id=0;
    }

    public Message(boolean isSucceed , String message, String url, int id) 
    {
        this.isSucceed = isSucceed;
        this.message = message;
        this.url=url;
        this.id=id;
    }
        
}
