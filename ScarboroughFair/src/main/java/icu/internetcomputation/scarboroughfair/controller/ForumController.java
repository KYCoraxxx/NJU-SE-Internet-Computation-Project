package icu.internetcomputation.scarboroughfair.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // TODO : 拉取帖子和评论

    // TODO : 查看帖子详情页

}
