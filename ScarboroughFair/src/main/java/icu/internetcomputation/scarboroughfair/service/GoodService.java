package icu.internetcomputation.scarboroughfair.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.Resource;
import icu.internetcomputation.scarboroughfair.GoodRepository;
import icu.internetcomputation.scarboroughfair.entity.Good;
import org.springframework.stereotype.Service;
import icu.internetcomputation.scarboroughfair.entity.Message;
import net.bytebuddy.asm.Advice.Return;

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

    public Message addGood(String name ,Float price, String cover, List<String> picture, String description, String tag)
    {
        int id = (int)goodRepository.count()+1;
        Good good = new Good(id, name, price, cover, picture, description, tag);
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
        return new Message(true,"商品下架了，怎会如此......");
    }

    public List<Good> findHot(int num){
        Iterable<Good> iterable = goodRepository.findAll();
        List<Good> list=StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());;
        Collections.sort(list, new Comparator<Good>(){
            public int compare(Good o1, Good o2){
                if(o1.getClick()>o2.getClick()) return -1;
                else if(o1.getClick()<o2.getClick()) return 1;
                else return 0;
            }
        });
        if(list.size()<num) num=list.size();

        return list.subList(0, num);
    }

}
