package icu.internetcomputation.scarboroughfair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Message checkUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword) 
    {
        return userService.checkUser(userName, userPassword);
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Message addUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword,
     @RequestParam(value="inputPwd") String avatorUrl)
    {
        return userService.addUser(userName, userPassword,avatorUrl);
    }

    @RequestMapping(path = "/editUser", method = RequestMethod.POST)
    @ResponseBody
    public Message editUser(@RequestParam(value="inputName") String userName , @RequestParam(value="inputPwd") String userPassword){
        // TODO:修改用户名和密码
        return null;
    }


}
