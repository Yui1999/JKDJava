package com.company;

import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcDemo7 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();
        UserInfo userInfo = findUser(username,password);
        if(userInfo == null) {
            System.out.println("输入用户名或密码错误！");
        }else{
            System.out.println("用户登录成功！");
            System.out.println(userInfo);
        }
    }
    private static UserInfo findUser(String username, String password) throws Exception {
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        UserInfo userInfo = null;
        try{
            String sql = "select * from userInfo where username='"+username+"'and password='"+password+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                userInfo = new UserInfo();
                userInfo.setUsername(rs.getString(2));
                userInfo.setPassword(rs.getString(3));

            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
        return userInfo;
    }
}
