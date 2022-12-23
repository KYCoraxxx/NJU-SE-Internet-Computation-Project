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

    public Message addPost(int userid, String content, String[] imgUrl){
        int postid = (int) (forumPostRepository.count() + 1);
        Long time = System.currentTimeMillis();
        ForumPost post = new ForumPost(postid, userid, content, imgUrl);
        forumPostRepository.save(post);
        return new Message(true, "帖子发布成功o(￣ε￣*)", null, postid);
    }

    public Message deletePost(int userid, int postid){
        ForumPost delpost= findForumPost(postid);
        int trueuser = delpost.getPostUserID();
        if(userid != trueuser){
            return new Message(false, "帖子被神秘的东方力量阻挡，无法删除");
        }
        forumPostRepository.delete(delpost);
        return new Message(true, "帖子忍痛离开了普罗丢瑟sama~( TロT)");
    }

    public Message addComment(int userid, String content, Integer postId){
        int commentid = (int) (commentRepository.count() + 1);
        Long time = System.currentTimeMillis();
        Comment comment = new Comment(postId, commentid, userid, time, content);
        commentRepository.save(comment);
        ForumPost forumPost = findForumPost(postId);
        int[] oldCommentID = forumPost.getCommentID();
        int[] newCommentID = new int[oldCommentID.length + 1];
        for(int i = 0; i < oldCommentID.length; i++){
            newCommentID[i] = oldCommentID[i];
        }
        newCommentID[oldCommentID.length] = commentid;
        forumPost.setCommentID(newCommentID);
        forumPostRepository.save(forumPost);
        return new Message(true, "您的评论已经传达到辣d=====(￣▽￣*)b");
    }

    public Message lovePost(Integer postid){
        ForumPost post = findForumPost(postid);
        post.setStarNum(post.getStarNum() + 1);
        forumPostRepository.save(post);
        return new Message(true, "非常好内容, 爱来自陶瓷");
    }

    public Message deleteComment(int userid, int commentid){
        Comment delComment = findComment(commentid);
        if(userid != delComment.getCommentUserID()){
            return new Message(false, "删除评论的权力被我夺舍了!");
        }
        int delCommentId = delComment.getCommentId();
        ForumPost forumPost = findForumPost(delComment.getPostId());
        int[] oldCommentID = forumPost.getCommentID();
        int[] newCommentID = new int[oldCommentID.length - 1];
        int i = 0, j = 0;
        while(i != oldCommentID.length - 1){
            if(oldCommentID[j] != delCommentId){
                newCommentID[i] = oldCommentID[j];
                i++;
            }
            j++;
        }
        forumPost.setCommentID(newCommentID);
        forumPostRepository.save(forumPost);
        commentRepository.delete(delComment);
        return new Message(true, "评论帮你删好了，再多夸夸我也没关系哦!");
    }
}
