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

    /*
     * 给定ID返回对应商品
     */
    @RequestMapping(value="/findById", method = RequestMethod.POST)
    @ResponseBody
    public Good findById(
        @RequestParam("id") int id){
        Good good=goodService.findById(id);
        
        return good;
    }

    /*
     * 热门商品
     */
    @RequestMapping(value="/findHot", method = RequestMethod.POST)
    @ResponseBody
    public List<Good> findHot(
        @RequestParam("number") int number){
        return goodService.findHot(number);
    }

    /*
     * 购买商品
     */
    @RequestMapping(value="/buyById", method = RequestMethod.POST)
    @ResponseBody
    public Message buyById(
        @RequestParam("id") int id){
        return goodService.buyGood(id);
    }

    
    /*
     * 删除商品
     */
    @RequestMapping(value="/deleteById", method = RequestMethod.POST)
    @ResponseBody
    public Message deleteGood(
        @RequestParam("id") int id){
        return goodService.deleteGood(id);
    }
    
    /*
     * 搜索商品
     */
    @RequestMapping(path = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Good search(
        @RequestParam("key") String key
    ){
        return goodService.search(key);
    }

}
