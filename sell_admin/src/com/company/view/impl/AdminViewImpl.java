package com.company.view.impl;

import com.company.Dao.AdminDao;
import com.company.Dao.impl.AdminDaoImpl;
import com.company.domain.Admin;
import com.company.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {
    private Scanner input =  new Scanner(System.in);

    public Admin login(){
        System.out.println("请输入用户名");
        String adminName = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        AdminDao dao = new AdminDaoImpl();
        Admin admin = dao.getAdminByNameAndPassword(adminName,password);
        return admin;
    }
}
