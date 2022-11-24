package icu.internetcomputation.scarboroughfair;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScarboroughFairController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
