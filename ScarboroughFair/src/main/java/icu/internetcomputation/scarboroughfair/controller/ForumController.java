package icu.internetcomputation.scarboroughfair.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import icu.internetcomputation.scarboroughfair.entity.Comment;
import icu.internetcomputation.scarboroughfair.entity.ForumPost;
import icu.internetcomputation.scarboroughfair.entity.Message;
import icu.internetcomputation.scarboroughfair.service.ForumService;

@Controller
@RequestMapping(path = "/ForumService", method = RequestMethod.POST, produces = "application/json")
public class ForumController {
    @Resource
    private ForumService forumService;

    @RequestMapping(path = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public Iterable<ForumPost> findAllPost()
    {
        return forumService.findAllPost();
    }

    @RequestMapping(path = "/findPostById", method = RequestMethod.POST)
    @ResponseBody
    public ForumPost findPostById(@RequestParam("id") int id){
        return forumService.findForumPost(id);
    }

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
    // @RequestMapping(path="/findComments",method = RequestMethod.POST)
    // @ResponseBody
    // public Iterable<Comment> findComments(@RequestParam("postid") int postid){
    //     List<Integer> ids=findCommentsId(postid);
    //     return forumService.findComments(ids);
    // }
    @RequestMapping(path="/findComments",method = RequestMethod.POST)
    @ResponseBody
    public List<Comment> findComments(@RequestParam("postid") int postid){
        List<Integer> ids=findCommentsId(postid);
        System.out.println("from");
        System.out.println(ids);
        Iterable<Comment> iterable = forumService.findComments(ids);
        System.out.println(iterable);
        System.out.println("end");
        List<Comment> ret = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        return ret;
    }
    // 废弃，使用uploadcontroller里面的
    // @RequestMapping(path = "/addPost", method = RequestMethod.POST)
    // @ResponseBody
    // public Message addPost(){
    //     return null;
    // }


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
    
    


    // TODO : 查看帖子详情页

}
