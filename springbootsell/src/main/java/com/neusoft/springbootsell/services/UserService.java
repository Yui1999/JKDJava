package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.UserInfo;

public interface UserService {
    UserInfo findByPhoneAndPassword(String userPhone,String password);
}
