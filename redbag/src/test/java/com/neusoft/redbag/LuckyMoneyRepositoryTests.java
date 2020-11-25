package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckyMoneyRepositoryTests {
    //再有Spring的地方这样创建对象，不用new
    @Autowired
    private LuckyMoneyRepository repository;

    @Test
    public void listAll(){
        List<LuckyMoney> list = repository.findAll();
        for(LuckyMoney luckyMoney: list){
            System.out.println(luckyMoney);
        }
    }

    @Test
    public void getById(){
        Optional<LuckyMoney> optional = repository.findById(2);
        System.out.println(optional);
    }
    @Test
    public void save(){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("大加加");
        luckyMoney.setMoney(new BigDecimal(32.32));
        luckyMoney.setProducer("小加加");
        //save是正常的保存
//        repository.save(luckyMoney);
        //saveAndFlush是在同一事物下提前就保存
        repository.saveAndFlush(luckyMoney);
    }
    @Test
    public void delete(){
        repository.deleteById(3);
    }
    @Test
    public void update(){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("小加加");
        luckyMoney.setMoney(new BigDecimal(32.32));
        luckyMoney.setProducer("谬加加");
        luckyMoney.setId(1);
        repository.save(luckyMoney);
    }
}
