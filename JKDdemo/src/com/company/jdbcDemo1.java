package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1、导入驱动jar包, 建立libs文件夹， 右键 add as library
        //2、 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取数据库连接对象
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://"+"localhost:3306/jkdjava","root","123456");
        //4、定义sql
        String sql = "insert into account values(null,'城钱伦',250)";
        //5、获取数据库连接对象statement
        Statement stmt = conn.createStatement();
        //6、执行sql
        int i = stmt.executeUpdate(sql);
        //7、处理结果
        if(i==1){
            System.out.println("插入成功!");
        }else{
            System.out.println("插入失败!");
        }
        //8、释放资源
        stmt.close();
        conn.close();
    }
}
