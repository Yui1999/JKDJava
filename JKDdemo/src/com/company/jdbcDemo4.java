package com.company;

import java.sql.*;

public class jdbcDemo4 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://"+"localhost:3306/jkdjava","root","123456");

        String sql = "select * from emp";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int EMPNO = rs.getInt("EMPNO");
            String ENAME = rs.getString("ENAME");
            String JOB = rs.getString("JOB");
            int MGR = rs.getInt("MGR");
            Date HIREDATE = rs.getDate("HIREDATE");
            double SAL = rs.getDouble("SAL");
            int COMM = rs.getInt("COMM");
            int DEPTNO = rs.getInt("DEPTNO");
            System.out.println(EMPNO+"---"+ENAME+"---"+JOB+"---"+MGR+
                    "---"+HIREDATE+"---"+SAL+"---"+COMM+"---"+DEPTNO);
        }

        stmt.close();
        conn.close();
    }
}
