package icu.internetcomputation.scarboroughfair.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import icu.internetcomputation.scarboroughfair.entity.Message;

@Controller
@RequestMapping(path = "/ForumService", method = RequestMethod.POST, produces = "application/json")
public class ForumController {
    @Resource
    private ForumController forumController;

    
}
