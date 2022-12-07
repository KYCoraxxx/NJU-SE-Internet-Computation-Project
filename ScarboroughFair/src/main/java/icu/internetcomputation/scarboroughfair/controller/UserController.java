package icu.internetcomputation.scarboroughfair.controller;

import icu.internetcomputation.scarboroughfair.entity.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import icu.internetcomputation.scarboroughfair.entity.User;
import icu.internetcomputation.scarboroughfair.entity.Message;
import icu.internetcomputation.scarboroughfair.service.UserService;
import javax.annotation.Resource;

@Controller
@RequestMapping(path = "/userService", method = RequestMethod.POST, produces = "application/json")
public class UserController
{
    @Resource
    private UserService userService;

    @RequestMapping(path = "/checkUser", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Message checkUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword) 
    {
        StringBuilder password = new StringBuilder();
        for(int i = 0; i < userPassword.length(); i += 2){
            password.append(userPassword.charAt(i));
        }
        Message message = userService.checkUser(userName, password.toString());
        return message;
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Message addUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword)
    {
        return userService.addUser(userName, userPassword, "null");
    }

    /*
     * <暂时废弃>，修改用户资料的接口在UploadController
     */
    @RequestMapping(path = "/editUser", method = RequestMethod.POST)
    @ResponseBody
    public Message editUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword){
        
        return null;
    }

    @RequestMapping(path="/getData", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Data getData(@RequestParam(value = "page") String page, @RequestParam(value = "userID") String id, Model model){
        return userService.getData(page, Integer.parseInt(id));
    }
}
