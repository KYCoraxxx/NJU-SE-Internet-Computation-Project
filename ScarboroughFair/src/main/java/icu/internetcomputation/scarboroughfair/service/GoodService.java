package icu.internetcomputation.scarboroughfair.service;

import javax.annotation.Resource;
import icu.internetcomputation.scarboroughfair.GoodRepository;
import icu.internetcomputation.scarboroughfair.entity.Good;
import org.springframework.stereotype.Service;
import icu.internetcomputation.scarboroughfair.entity.Message;

@Service
public class GoodService {
    @Resource
    GoodRepository goodRepository;

    public Iterable<Good> findAll()
    {
        return goodRepository.findAll();
    }

    public Good findById(int id)
    {
        return goodRepository.findById(id).orElse(null);
    }

    public Message addGood(String name ,Float price, String picture, String description)
    {
        int id = (int)goodRepository.count()+1;
        Good good = new Good(id,name,price,picture,description);
        goodRepository.save(good);
        return new Message(true,"您的宝贝，堂堂上架！");
    }

    public Message buyGood(int id)
    {
        goodRepository.deleteById(id);
        return new Message(true,"购买成功！霖之助桑感谢您的惠顾ヾ(ﾟ∀ﾟゞ)");
    }

    public Message deleteGood(int id)
    {
        goodRepository.deleteById(id);
        return new Message(true,"下架成功！");
    }



}
