package icu.internetcomputation.scarboroughfair.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "comment")
public class Comment {
    // 论坛中的评论类


    // 与对应的帖子的id保持一致
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private User CommentUser;

    // 点赞数量
    @Getter
    @Setter
    private Integer starNum;

    @Getter
    @Setter
    private Calendar CommentTime;

    @Setter
    @Getter
    private String content;

    Comment(){
        this.id = -1;
        this.starNum = 0;
        this.CommentUser = null;
        this.CommentTime = null;
        this.content = null;
    }

    Comment(Integer id, User CommentUser, Calendar CommentTime, String content){
        this.id = id;
        this.CommentUser = CommentUser;
        this.CommentTime = CommentTime;
        this.content = content;
    }

    /*
     * # forum需求
        1. 发帖用户信息（名字username，头像avator）
       √ 2. 评论的用户信息（可能需要一个数组吧很多个评论commentUser）
        3. 发帖的内容
        1. 文字 content
        2. 图像（九宫格）image
       √ 4. 评论的内容
       √ 1. 文字 commentContent
        5. 发帖的，评论数记录，点赞数记录 commentNumber starNumber
       √ 6. 评论的点赞数记录，点记录 commentStarNumber commentDislikeNumber
       √ 7. 帖子和评论发出时间的记录 twitterTime commentTime
     */
}
