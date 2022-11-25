package icu.internetcomputation.scarboroughfair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class ScarboroughFairController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUser() {
        return userRepository.findAll();
    }
}
