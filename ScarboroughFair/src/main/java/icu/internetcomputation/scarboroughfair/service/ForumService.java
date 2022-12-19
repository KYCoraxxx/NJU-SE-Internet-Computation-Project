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

    public Message deletePost(int postid){
        ForumPost delpost= findForumPost(postid);
        forumPostRepository.delete(delpost);
        return new Message(true, "帖子忍痛离开了普罗丢瑟sama~( TロT)");
    }

    public Message addComment(User user, String content, Integer postId){
        int commentid = (int) (commentRepository.count() + 1);
        int userid = user.getId();
        Long time = System.currentTimeMillis();
        Comment comment = new Comment(postId, commentid, userid, time, content);
        commentRepository.save(comment);
        return new Message(true, "您的评论已经传达到辣d=====(￣▽￣*)b");
    }

    public Message lovePost(Integer postid){
        ForumPost post = findForumPost(postid);
        post.setStarNum(post.getStarNum() + 1);
        forumPostRepository.save(post);
        return new Message(true, "非常好内容, 爱来自陶瓷");
    }

    public Message deleteComment(Integer commentid){
        Comment delComment = findComment(commentid);
        commentRepository.delete(delComment);
        return new Message(true, "评论帮你删好了，感谢我吧!");
    }
}
