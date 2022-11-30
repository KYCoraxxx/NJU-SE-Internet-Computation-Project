package icu.internetcomputation.scarboroughfair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import icu.internetcomputation.scarboroughfair.entity.User;
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

    @GetMapping("/HomePage")
    public String HomePage(Model model){
        return "HomePage";
    }

    // @RequestMapping(path = "/all")
    // public @ResponseBody Iterable<User> getAllUser() {
    //     return userRepository.findAll();
    // }
    // @PostMapping(path = "/UserChecker")
    // @ResponseBody
    // public UserChecker UserChecker(String inputName,String inputPwd)
    // {
    //     Iterable<User> userList=userRepository.findAll();
    //     boolean isUserExist=false;
    //     boolean isPasswordRight=false;
    //     for(User user:userList)
    //     {
    //         if(user.getName().equals(inputName))
    //         {
    //             isUserExist=true;
    //             if(user.getPassword().equals(inputPwd))
    //             {
    //                 isPasswordRight=true;
    //                 break;
    //             }
    //         }
    //     }
    //     return new UserChecker(isUserExist,isPasswordRight);  
    // }
    @Controller
    @RequestMapping(path = "/userService",produces="application/json")
    public class UserController
    {
        private UserService userService = new UserService(userRepository);

        @RequestMapping(path = "/checkUser")
        @ResponseBody
        public Message checkUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword) 
        {
            return userService.checker(userName, userPassword);
        }

        @RequestMapping(path = "/addUser")
        @ResponseBody
        public Message addUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword)
        {
            return userService.add(userName, userPassword);
        }

        @RequestMapping(path = "/editUser")
        @ResponseBody
        public Message editUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword){
            // TODO:修改用户名和密码
            return null;
        }
    }
}
