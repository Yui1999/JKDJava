package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    public UserRepository repository;

    @Test
    public void listAll(){
        List<User> list = repository.findAll();
        for(User user: list){
            System.out.println(user);
        }
    }

    @Test
    public void getById(){
        String id = "2";
        Optional<User> optional = repository.findById(id);
        User user = optional.get();
        System.out.println(user);
    }

    @Test
    public void save(){
        User user = new User();
        user.setUsername("Atago");
        user.setPassword("369123");
        user.setEmail("atago123@139.com");
        repository.save(user);
    }

    @Test
    public void delete(){
        String id = "001";
        repository.deleteById(id);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId("8a04ae2275fe88bf0175fe88c38f0000");
        user.setUsername("Eugen");
        user.setPassword("147258");
        user.setEmail("eugen123@139.com");
        repository.save(user);
    }
}
