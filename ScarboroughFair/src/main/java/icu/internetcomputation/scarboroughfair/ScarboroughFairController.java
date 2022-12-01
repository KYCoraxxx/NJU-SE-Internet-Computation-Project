package icu.internetcomputation.scarboroughfair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import icu.internetcomputation.scarboroughfair.entity.Message;
import icu.internetcomputation.scarboroughfair.service.UserService;
import org.springframework.ui.Model;

@Controller
public class ScarboroughFairController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/index")
    public String homepage(Model model){
        return "index";
    }

    @Controller
    @RequestMapping(path = "/userService", method = RequestMethod.POST, produces = "application/json")
    public class UserController
    {
        private UserService userService = new UserService(userRepository);

        @RequestMapping(path = "/checkUser", method = RequestMethod.POST)
        @ResponseBody
        public Message checkUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword) 
        {
            return userService.checkUser(userName, userPassword);
        }

        @RequestMapping(path = "/addUser", method = RequestMethod.POST)
        @ResponseBody
        public Message addUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword)
        {
            return userService.addUser(userName, userPassword);
        }

        @RequestMapping(path = "/editUser", method = RequestMethod.POST)
        @ResponseBody
        public Message editUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword){
            // TODO:修改用户名和密码
            return null;
        }
    }
}
