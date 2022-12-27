package icu.internetcomputation.scarboroughfair.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import icu.internetcomputation.scarboroughfair.CommentRepository;
import icu.internetcomputation.scarboroughfair.ForumPostRepository;
import icu.internetcomputation.scarboroughfair.entity.Comment;
import icu.internetcomputation.scarboroughfair.entity.ForumPost;
import icu.internetcomputation.scarboroughfair.entity.Message;

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

    public Iterable<Comment> findComments(List<Integer> ids){
        if(ids.size()==0) return null;
        return commentRepository.findAllById(ids);
    }

    public Message addPost(int userid, String content, List<String> imgUrl){
        int postid = (int) (forumPostRepository.count() + 1);
        Date time = new Date();
        ForumPost post = new ForumPost(postid, userid, content, imgUrl,time);
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
        Date time = new Date();
        Comment comment = new Comment(postId, commentid, userid, time, content);
        commentRepository.save(comment);
        ForumPost forumPost = findForumPost(postId);
        List<Integer> commentsID = forumPost.getCommentsId();
        commentsID.add(commentid);
        forumPost.setCommentsId(commentsID);
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
        ForumPost forumPost = findForumPost(delComment.getPostId());
        List<Integer> commentsID = forumPost.getCommentsId();
        for(int i=0;i<commentsID.size();i++)
            if(commentsID.get(i).equals(commentid)){
                commentsID.remove(i);
                break;
            }
        forumPost.setCommentsId(commentsID);
        forumPostRepository.save(forumPost);
        commentRepository.delete(delComment);
        return new Message(true, "评论帮你删好了，再多夸夸我也没关系哦!");
    }
}
