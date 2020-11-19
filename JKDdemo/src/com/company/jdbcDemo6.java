package com.company;

import com.company.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcDemo6 {
    public static void main(String[] args) throws Exception{
        List<Emp> empList = findAll();
        for (Emp e:empList){
            System.out.println(e);
        }
    }
    public static List<Emp> findAll() throws Exception{
        // 多态写法： 父类引用指向子类对象
        // 声明一个list 存储所有emp对象
        List<Emp> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from emp";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            int EMPNO = rs.getInt(1);
            String ENAME = rs.getString(2);
            String JOB = rs.getString(3);
            int MGR = rs.getInt(4);
            Date HIREDATE = rs.getDate(5);
            double SAL = rs.getDouble(6);
            int COMM = rs.getInt(7);
            int DEPTNO = rs.getInt(8);
            Emp emp = new Emp(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO);
            list.add(emp);
        }
        JDBCUtil.close(rs,stmt,conn);
        return  list;
    }
}
