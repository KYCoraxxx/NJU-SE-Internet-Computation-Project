package icu.internetcomputation.scarboroughfair.service;

import icu.internetcomputation.scarboroughfair.UserRepository;
import icu.internetcomputation.scarboroughfair.entity.Data;
import icu.internetcomputation.scarboroughfair.entity.User;
import icu.internetcomputation.scarboroughfair.entity.Message;
import java.util.Optional;

import javax.annotation.Resource;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    public Iterable<User> findAll()
    {
        return userRepository.findAll();
    }

    public User findById(int id)
    {
       return userRepository.findById(id).orElse(null);
    }

    public User findByUserName(String username)
    {
        Iterable<User> userTable = findAll();
        for (User user : userTable) 
        {
            if(user.getName().equals(username))
            {
                return user;
            }
        }
        return null;
    }

    public Message addUser(String userName, String userPassword, String avatorUrl)
    {
        User u = findByUserName(userName);
        if(u != null)
        {
            return new Message(false,"主人重名了啦……(；′⌒`)");
        }
        int id = (int)userRepository.count() + 1;
        User user = new User(id, userName, userPassword, avatorUrl);
        userRepository.save(user);
        return new Message(true,"欢迎来到☯幻想乡☯o(*￣▽￣*)ブ",null,id);
    }

    public Data getData(String page, int userID){
        User user = findById(userID);
        return new Data(user.getId(), user.getName(), user.getAvatorUrl());
    }

    public Message checkUser(String userName, String userPassword)
    {
        User user = findByUserName(userName);
        if(user == null)
        {
            return new Message(false, "你真的是这个世界的人嘛(・∀・(・∀・(・∀・*)");
        }
        if(!user.getPassword().equals(userPassword))
        {
            return new Message(false,"符卡记错了……┭┮﹏┭┮");
        }else
        {
            return new Message(true,String.format("欢迎回家！要来杯红茶吗， %s sama~o(*￣▽￣*)ブ？",user.getName()),null, user.getId());
        }
    }
    
    public Message editUser(Integer id, String avatorUrl, String name, String signature)
    {
        User user = findById(id);
        if(user == null)
        {
            return new Message(false, "啊咧，好像出错了(@ _ @;)");
        }else{
            if(name != null)
            {
                user.setName(name);
            }
            
            if(avatorUrl != null)
            {
                user.setAvatorUrl(avatorUrl);
            }
            
            if(signature != null){
                user.setSignature(signature);
            }
        }
        
        
        return new Message(true,"用户信息改好了~，多亏了八云紫大人(*/ω＼*)",avatorUrl);
    }
}
