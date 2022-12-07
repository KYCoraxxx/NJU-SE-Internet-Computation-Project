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

    @GetMapping("/undone")
    public String undone(Model model){ return "undone"; }

    @GetMapping("/usercenter")
    public String usercenter(Model model){ return "usercenter"; }
}
