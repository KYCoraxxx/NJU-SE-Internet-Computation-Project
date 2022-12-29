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

    String[] existsPage = {
        "login", "index", "forum",
        "upload", "detail", "usercenter",
        "undone", "help"
    };

    /**
     * 去到page.html页面
     * @return
     */
    @RequestMapping("/{page}")
    public String toPage(@PathVariable String page) {
        for(String i : existsPage){
            if(page.equals(i)) return page;
        }
        return "undone";
    }

}
