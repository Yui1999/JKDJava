package com.company;

import java.sql.*;
import com.company.Emp;

public class jdbcDemo4 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://"+"localhost:3306/jkdjava","root","123456");

        String sql = "select * from emp";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

//        while(rs.next()){
//            int EMPNO = rs.getInt("EMPNO");
//            String ENAME = rs.getString("ENAME");
//            String JOB = rs.getString("JOB");
//            int MGR = rs.getInt("MGR");
//            Date HIREDATE = rs.getDate("HIREDATE");
//            double SAL = rs.getDouble("SAL");
//            int COMM = rs.getInt("COMM");
//            int DEPTNO = rs.getInt("DEPTNO");
//            System.out.println(EMPNO+"---"+ENAME+"---"+JOB+"---"+MGR+
//                    "---"+HIREDATE+"---"+SAL+"---"+COMM+"---"+DEPTNO);
//        }
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
            System.out.println(emp);
        }
        stmt.close();
        conn.close();
    }
}
