package com.neusoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//相当于@Controller 和 @ResponseBody
//@Controller 是将此类交给Spring进行管理
//@ResponseBody 是返回给客户端的回应
@RestController
@RequestMapping("/bag")
public class LuckyMoneyController {

    //注入dao层接口
    @Autowired
    private LuckyMoneyRepository repository;

    /**
     * 获取红包列表
     * @return
     */
    @GetMapping("/list")
//    @RequestMapping("/list")
    public List<LuckyMoney> list(){
        return repository.findAll();
    }

    /**
     * 发送红包
     * @param producer
     * @param money
     * @return luckyMoney
     */
    @PostMapping("/post")
    public LuckyMoney postRedBag(@RequestParam(value = "producer",required = true)String producer,@RequestParam(value = "money",required = true)BigDecimal money){
       LuckyMoney luckyMoney = new LuckyMoney();
       luckyMoney.setProducer(producer);
       luckyMoney.setMoney(money);
       return repository.save(luckyMoney);
    }

    /**
     * 根据id查找红包
     * @param id
     * @return luckyMoney
     */
    @GetMapping("/find/{id}")
    public LuckyMoney findById(@PathVariable("id") Integer id){
//        Optional<LuckyMoney> optional = repository.findById(id);
//        if(optional.isPresent()){
//            LuckyMoney luckyMoney = optional.get();
//            return luckyMoney;
//        }
//        return null;
        //如果有就返回luckyMoney对象，如果没有就返回other
        return repository.findById(id).orElse(null);
    }

    /**
     * 收红包
     * @param id
     * @param consumer
     * @return luckyMoney
     */
    @PutMapping("/put/{id}")
    public LuckyMoney put(@PathVariable("id") Integer id, @RequestParam("consumer") String consumer){
        Optional<LuckyMoney> optional = repository.findById(id);
        if(optional.isPresent()){
            LuckyMoney luckyMoney = optional.get();
            luckyMoney.setConsumer(consumer);
            return repository.save(luckyMoney);
        }
        return null;
    }


}
