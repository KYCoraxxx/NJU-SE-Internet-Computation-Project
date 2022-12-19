package icu.internetcomputation.scarboroughfair.service;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import icu.internetcomputation.scarboroughfair.CommentRepository;
import icu.internetcomputation.scarboroughfair.ForumPostRepository;
import icu.internetcomputation.scarboroughfair.entity.Comment;
import icu.internetcomputation.scarboroughfair.entity.ForumPost;
import icu.internetcomputation.scarboroughfair.entity.Message;
import icu.internetcomputation.scarboroughfair.entity.User;

@Service
public class ForumService {
    @Resource
    CommentRepository commentRepository;

    @Resource
    ForumPostRepository forumPostRepository;


    public Iterable<ForumPost> findAllPost()
    {
        return forumPostRepository.findAll();
    }

    public Iterable<Comment> findAllComment()
    {
        return commentRepository.findAll();
    }

    public ForumPost findForumPost(int id){
        return forumPostRepository.findById(id).orElse(null);
    }

    public Comment findComment(int id){
        return commentRepository.findById(id).orElse(null);
    }

    public Message addPost(User user, String content, String[] imgUrl){
        int postid = (int) (forumPostRepository.count() + 1);
        int userid = user.getId();
        Long time = System.currentTimeMillis();
        ForumPost post = new ForumPost(postid, userid, content, imgUrl, time);
        forumPostRepository.save(post);
        return new Message(true, "帖子发布成功o(￣ε￣*)", null, postid);
    }

}
