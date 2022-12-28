package icu.internetcomputation.scarboroughfair.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Entity
@Table(name = "comment_test")
public class Comment {
    // 论坛中的评论类


    /*
     * 这里有两个ID CommentId是评论自身的编号， 而PostId是对应的post的编号
     */

    // 评论自身的编号
    @Id
    @Getter
    @Setter
    private Integer id;


    // 与对应的帖子的id保持一致
    @Getter
    @Setter
    private Integer PostId;

    
    @Getter
    @Setter
    private Integer CommentUserID;

    // 点赞数量
    @Getter
    @Setter
    private Integer starNum;

    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date CommentTime;

    @Setter
    @Getter
    private String content;

    public Comment(){
        this.PostId = -1;
        this.id = -1;
        this.starNum = 0;
        this.CommentUserID = null;
        this.CommentTime = null;
        this.content = null;
    }

    public Comment(Integer PostId,Integer Id, Integer CommentUserID, Date CommentTime, String content){
        this.PostId = PostId;
        this.id = Id;
        this.CommentUserID = CommentUserID;
        this.CommentTime = CommentTime;
        this.content = content;
        this.starNum = 0;
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
