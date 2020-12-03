package com.neusoft.springbootsell.dataobject;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class UserInfo {
    @Id
    private Integer id;

    private String password;

    private String userPhone;

}
