package icu.internetcomputation.scarboroughfair.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import icu.internetcomputation.scarboroughfair.entity.Comment;
import icu.internetcomputation.scarboroughfair.entity.ForumPost;
import icu.internetcomputation.scarboroughfair.entity.Message;
import icu.internetcomputation.scarboroughfair.service.ForumService;

@Controller
@RequestMapping(path = "/ForumService", method = RequestMethod.POST, produces = "application/json")
@CrossOrigin
public class ForumController {
    @Resource
    private ForumService forumService;

    @RequestMapping(path = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public Iterable<ForumPost> findAllPost()
    {
        return forumService.findAllPost();
    }

    /*
     * 根据给定的帖子ID, 返回该帖子
     */
    @RequestMapping(path = "/findPostById", method = RequestMethod.POST)
    @ResponseBody
    public ForumPost findPostById(@RequestParam("id") int id){
        return forumService.findForumPost(id);
    }

    /*
     * 根据给定的评论ID, 返回该评论
     */
    @RequestMapping(path = "/findCommentById", method = RequestMethod.POST)
    @ResponseBody
    public Comment findCommentById(@RequestParam("id") int id){
        return forumService.findComment(id);
    }

    /*
     * 根据给定的帖子 返回帖子所有的评论的ID
     */
    @RequestMapping(path = "/findCommentsId", method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> findCommentsId(@RequestParam("postid") int postid){
        ForumPost forumPost = forumService.findForumPost(postid);
        return forumPost.getCommentsId();
    }
    
    /*
     * 获取帖子所有评论
     */
    @RequestMapping(path="/findComments",method = RequestMethod.POST)
    @ResponseBody
    public List<Comment> findComments(@RequestParam("postid") int postid){
        List<Integer> ids=findCommentsId(postid);
        Iterable<Comment> iterable = forumService.findComments(ids);
        if(iterable != null) {
            List<Comment> ret = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
            return ret;
        }
        return null;
    }

    /*
     * 点赞
     */
    @RequestMapping(path = "/Star", method = RequestMethod.POST)
    @ResponseBody
    public Message StarPost(
        @RequestParam("postid") int postid
    ){
        
        return forumService.lovePost(postid);
    }
    @RequestMapping(path="/CommentStar",method=RequestMethod.POST)
    @ResponseBody
    public Message StarComment(
        @RequestParam("commentid") int commentid
    ){
        return forumService.loveComment(commentid);
    }

    /*
     * 添加评论
     */
    @RequestMapping(path = "/CommentPost", method = RequestMethod.POST)
    @ResponseBody
    public Message CommentPost(
        @RequestParam("comment") String comment,
        @RequestParam("userid") int userid,
        @RequestParam("postid") int postid)
    {
        return forumService.addComment(userid, comment, postid);
    }

    /*
     * 删除帖子
     */
    @RequestMapping(path = "/DelPost", method = RequestMethod.POST)
    @ResponseBody
    public Message DelPost(
        @RequestParam("userid") int userid,
        @RequestParam("postid") int postid)
    {
        return forumService.deletePost(userid, postid);
    }

    /*
     * 删除评论
     */
    @RequestMapping(value="/DelComment", method=RequestMethod.POST)
    public Message requestMethodName(
        @RequestParam("userid") int userid,
        @RequestParam("commentid") int commentid) 
    {
        return forumService.deleteComment(userid, commentid);
    }
    
    








}
