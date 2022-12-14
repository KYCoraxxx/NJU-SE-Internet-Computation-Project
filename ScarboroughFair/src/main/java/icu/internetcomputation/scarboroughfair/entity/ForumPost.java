package icu.internetcomputation.scarboroughfair.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "forumpost")
public class ForumPost {
    // 论坛中的帖子类
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;


    // 发帖者
    @Getter
    @Setter
    private User forumUser; 
    

    // 帖子内容
    @Getter
    @Setter
    private String content; 

    // 帖子图片
    @Getter
    @Setter
    private String[] imgUrl;

    // 点赞
    @Getter
    @Setter int starNum;

    //发帖时间
    @Getter
    @Setter 
    private Calendar postTime;


    /*
     * # forum需求
       √ 1. 发帖用户信息（名字username，头像avator）
        2. 评论的用户信息（可能需要一个数组吧很多个评论commentUser）
       √ 3. 发帖的内容
       √ 1. 文字 content
       √ 2. 图像（九宫格）image
        4. 评论的内容
        1. 文字 commentContent
       √ 5. 发帖的，评论数记录，点赞数记录 commentNumber starNumber
        6. 评论的点赞数记录，点踩数记录 commentStarNumber commentDislikeNumber
        7. 帖子和评论发出时间的记录 twitterTime commentTime
     */
}
