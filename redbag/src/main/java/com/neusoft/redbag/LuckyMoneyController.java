package com.neusoft.redbag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

//相当于@Controller 和 @ResponseBody
//@Controller 是将此类交给Spring进行管理
//@ResponseBody 是返回给客户端的回应
@RestController
public class LuckyMoneyController {

    @Autowired
    private LuckyMoneyRepository repository;

    /**
     * 获取红包列表
     * @return
     */
//    @GetMapping("/list")
    @RequestMapping("/list")
    public List<LuckyMoney> list(){
        return repository.findAll();
    }

    /**
     * 发送红包
     * @param producer
     * @param money
     * @return
     */
    @RequestMapping("/post")
    public LuckyMoney postRedBag(@RequestParam(value = "producer",required = true)String producer,@RequestParam(value = "money",required = true)BigDecimal money){
       LuckyMoney luckyMoney = new LuckyMoney();
       luckyMoney.setProducer(producer);
       luckyMoney.setMoney(money);
       return repository.save(luckyMoney);
    }
}
