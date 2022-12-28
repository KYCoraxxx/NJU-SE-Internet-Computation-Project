package icu.internetcomputation.scarboroughfair.controller;

import java.util.List;

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
@RequestMapping(path = "/GoodService", method = RequestMethod.POST, produces = "application/json")
public class GoodController {
    @Resource
    private GoodService goodService;



    @RequestMapping(path = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public Iterable<Good> findAll(){
        return goodService.findAll();
    }

    @RequestMapping(value="/findById", method = RequestMethod.POST)
    @ResponseBody
    public Good findById(
        @RequestParam("id") int id){
        Good good=goodService.findById(id);
        
        return good;
    }

    @RequestMapping(value="/findHot", method = RequestMethod.POST)
    @ResponseBody
    public List<Good> findHot(
        @RequestParam("number") int number){
        return goodService.findHot(number);
    }

    @RequestMapping(value="/buyById", method = RequestMethod.POST)
    @ResponseBody
    public Message buyById(
        @RequestParam("id") int id){
        return goodService.buyGood(id);
    }

    /*
     * <暂时废弃>，添加商品的接口在uploadcontroller
     */
    // @RequestMapping(value = "/addGood",method = RequestMethod.POST)
    // @ResponseBody
    // public Message addGood(@RequestParam("name") String name ,@RequestParam("tag") String tag,
    // @RequestParam("price") Float price,@RequestParam("cover") String cover, 
    // @RequestParam("pic") String picture,@RequestParam("description") String description)
    // {
    //     return goodService.addGood(name, price, cover, picture, description, tag);
    // }

    @RequestMapping(value="/deleteById", method = RequestMethod.POST)
    @ResponseBody
    public Message deleteGood(
        @RequestParam("id") int id){
        return goodService.deleteGood(id);
    }
    

}
