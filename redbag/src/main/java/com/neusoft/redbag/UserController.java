package com.neusoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserRepository repository;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/list")
    public List<User> list(){
        return repository.findAll();
    }

//    @PostMapping("/post")
//    public User postUser(){
//        User user = new User();
//        user.setId(id)
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEmail(email);
//        return repository.save(user);
//    }
//
//    @GetMapping("/find/{id}")
//    public User findById(@PathVariable("id") String id){
//        return repository.findById(id).orElse(null);
//    }
//
}
