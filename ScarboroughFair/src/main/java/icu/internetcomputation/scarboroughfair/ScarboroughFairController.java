package icu.internetcomputation.scarboroughfair;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ScarboroughFairController {

    @GetMapping("/ScarboroughFair")
    public @ResponseBody String test(){
        return "hello, world";
    }

}
