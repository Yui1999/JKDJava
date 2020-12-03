package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findByUserPhoneAndPassword(String userPhone,String password);
}
