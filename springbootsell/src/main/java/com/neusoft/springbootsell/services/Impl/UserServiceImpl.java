package com.neusoft.springbootsell.services.Impl;

import com.neusoft.springbootsell.dataobject.UserInfo;
import com.neusoft.springbootsell.repository.UserInfoRepository;
import com.neusoft.springbootsell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoRepository repository;

    @Override
    public UserInfo findByPhoneAndPassword(String userPhone, String password) {
        return repository.findByUserPhoneAndPassword(userPhone,password);
    }
}
