package com.company;

import com.company.domain.Admin;
import com.company.view.AdminView;
import com.company.view.BusinessView;
import com.company.view.impl.AdminViewImpl;
import com.company.view.impl.BusinessViewImpl;

import java.util.Scanner;

public class ElmAdminEntry {

    public static void main(String[] args) {
        run();
    }
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("-------------钱航网上食堂管理系统-------------");
        System.out.println("------------------------------------------");
        AdminView adminView = new AdminViewImpl();
        BusinessView businessView = new BusinessViewImpl();
        Admin admin = adminView.login();
        int menu = 0;
        if(admin != null){
            System.out.println("登录成功");
            while(menu != 5){
                System.out.println("1、查看所有商家  2、搜索商家  3、新建商家  4、删除商家  5、退出系统");
                System.out.println("请输入你要选择的操作序号");
                menu = input.nextInt();
                switch (menu){
                    case 1:
                        businessView.listAllBusinesses();
                        break;
                    case 2:
                        businessView.selectBusinesses();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.removeBusiness();
                        break;
                    case 5:
                        System.out.println("欢迎下次登录");
                        break;
                    default:
                        System.out.println("没有这个选项");
                        break;
                }
            }
        }else{
            System.out.println("登陆失败，用户名或密码错误！");
        }
    }
}
