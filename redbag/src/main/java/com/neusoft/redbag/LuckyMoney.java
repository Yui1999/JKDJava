package com.neusoft.redbag;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * LuckyMoney 是与数据库字段一一对应的表
 * JavaBean格式
 */
@Entity
//重载getter  setter 等方法
@Data
//指定无参构造器
@NoArgsConstructor
public class LuckyMoney {
    //@Data lombok插件的一个注解，标识此注解的实体类不用自己写get和set方法
    // @Entity指定该类是实体类  @Id代表主键 @GeneratedValue代表自增长
    @Id
    @GeneratedValue
    private Integer id;
    //红包金额
    private BigDecimal money;
    //指定发红包的人
    private String producer;
    //指定收红包的人
    private String consumer;


}
