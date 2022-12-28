package icu.internetcomputation.scarboroughfair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import icu.internetcomputation.scarboroughfair.entity.Message;
import icu.internetcomputation.scarboroughfair.service.UserService;
import org.springframework.ui.Model;

@Controller
public class ScarboroughFairController {

    /**
     * 去到page.html页面
     * @return
     */
    // @RequestMapping("/{page}")
    // public String toPage(@PathVariable String page) {
    //     return page;
    // }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(path="/index",method = RequestMethod.GET)
    public String homepage(Model model){
        return "index";
    }

    @GetMapping("/forum")
    public String forum(Model model){ return "forum"; }

    @GetMapping("/upload")
    public String upload(Model model){ return "upload"; }

    @GetMapping("/detail")
    public String detail(Model model){ return "detail"; }

    @GetMapping("/undone")
    public String undone(Model model){ return "undone"; }

    @GetMapping("/usercenter")
    public String usercenter(Model model){ return "usercenter"; }

    @GetMapping("/help")
    public String help(Model model){ return "help"; }

}
