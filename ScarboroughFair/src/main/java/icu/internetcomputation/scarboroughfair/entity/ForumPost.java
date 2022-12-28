package icu.internetcomputation.scarboroughfair.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Entity
@Table(name = "forumpost")
public class ForumPost {
    // 论坛中的帖子类

    @Id
    @Getter
    @Setter
    private Integer id;


    // 发帖者 ID
    @Getter
    @Setter
    private Integer PostUserID; 
    

    // 帖子内容
    @Getter
    @Setter
    private String content; 

    
    // 帖子图片
    @Getter
    @Setter
    @ElementCollection(targetClass=String.class)
    private List<String> imgUrl;

    // 点赞
    @Getter
    @Setter 
    private Integer starNum;

    //发帖时间
    @Getter
    @Setter 
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date PostTime;

    //评论
    // @Setter
    // @Getter
    // private int[] commentID;

    @Setter
    @Getter
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> commentsId;

    public ForumPost(){
        id = -1;
        PostUserID = null;
        content = null;
        imgUrl = null;
        starNum = 0;
        PostTime = null;
        commentsId = new ArrayList<Integer>();
    }

    public ForumPost(Integer id, Integer postUserID, String content, List<String> imgUrl){
        this.id = id;
        this.PostUserID = postUserID;
        this.content = content;
        this.imgUrl = imgUrl;
        this.starNum = 0;
        this.PostTime = new Date();
        commentsId = new ArrayList<Integer>();
    }


}
