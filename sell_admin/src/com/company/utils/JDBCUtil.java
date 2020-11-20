package com.company.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBCUtil连接数据库工具类
 */
public class JDBCUtil {
    //定义成员变量DataSource
    private static DataSource ds;
    // 初始化静态成员变量
    static {
        try {
            Properties pro = new Properties();
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            //给ds进行初始化
            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        return ds.getConnection();
    }

    /**
     * 关闭连接
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        close(null,stmt,conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
