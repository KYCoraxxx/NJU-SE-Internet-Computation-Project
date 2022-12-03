package icu.internetcomputation.scarboroughfair.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import icu.internetcomputation.scarboroughfair.entity.Good;
import icu.internetcomputation.scarboroughfair.entity.Message;
import icu.internetcomputation.scarboroughfair.service.GoodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(path = "/goodService", method = RequestMethod.POST, produces = "application/json")
public class GoodController {
    @Resource
    private GoodService goodService;

    @RequestMapping(path = "/findAll", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Iterable<Good> findAll()
    {
        return goodService.findAll();
    }

    @RequestMapping(value="/findById", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Good findById(@RequestParam("id") int id)
    {
        return goodService.findById(id);
    }

    @RequestMapping(value="/buyById", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Message buyById(@RequestParam("id") int id)
    {
        return goodService.buyGood(id);
    }

    @RequestMapping(value = "/addGood",method = RequestMethod.POST, produces = "application")
    @ResponseBody
    public Message addGood(@RequestParam("GoodName") String name ,@RequestParam("GoodPrice") Float price,@RequestParam("GoodPicUrl") String picture,@RequestParam("GoodDes") String description)
    {
        return goodService.addGood(name, price, picture, description);
    }
    @RequestMapping(value="/deleteById", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Message deleteGood(@RequestParam("id") int id)
    {
        return goodService.deleteGood(id);
    }
    

}
