package com.neusoft.springbootsell.controller;


import com.neusoft.springbootsell.dataobject.UserInfo;
import com.neusoft.springbootsell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/seller/users")
public class SellerUsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView login(){
        return new ModelAndView("users/login");
    }

    @PostMapping("/login")
    public ModelAndView register(@Valid UserInfo form,ModelAndView view){
        UserInfo userInfo = userService.findByPhoneAndPassword(form.getUserPhone(), form.getPassword());
        if(userInfo != null){
            view.setViewName("redirect:/seller/product/list");
            return view;
        }
        view.setViewName("redirect:/seller/users/");
        return view;
    }

    @GetMapping("/logon")
    public ModelAndView logon(){
        return new ModelAndView("users/logon");
    }
}
