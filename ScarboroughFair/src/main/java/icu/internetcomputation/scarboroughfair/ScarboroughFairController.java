package icu.internetcomputation.scarboroughfair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import icu.internetcomputation.scarboroughfair.entity.UserChecker;

import org.springframework.ui.Model;

@Controller
@CrossOrigin()
public class ScarboroughFairController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    // @RequestMapping(path = "/all")
    // public @ResponseBody Iterable<User> getAllUser() {
    //     return userRepository.findAll();
    // }
    @RequestMapping(path = "/UserChecker")
    @ResponseBody
    public UserChecker UserChecker(String inputName,String inputPwd)
    {
        Iterable<User> userList=userRepository.findAll();
        boolean isExist=false;boolean isPwdRight=false;
        for(User user:userList)
        {
            if(user.getName().equals(inputName))
            {
                isExist=true;
                if(user.getPassword().equals(inputPwd))
                {
                    isPwdRight=true;
                    break;
                }
            }
        }

        return new UserChecker(isExist,isPwdRight);
            
    }
}
