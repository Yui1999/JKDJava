package com.company.Dao.impl;

import com.company.domain.Business;
import com.company.utils.JDBCUtil;
import com.company.Dao.BusinessDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao{
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<Business> listBusiness() {
        ArrayList<Business> list = new ArrayList<>();
        String sql = "select * from business";
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                Business business = new Business();
                String businessName = rs.getString(3);
                business.setBusinessName(businessName);
                list.add(business);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public int saveBusiness(String businessName) {
        int businessId = 0;
        // 希望插入一个商家的时候自动给一个默认密码
        String sql = "insert into business(businessName, password) values (?, '123') ";
        try {
            conn = JDBCUtil.getConnection();
            // 要设置返回自增长的键
            pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, businessName);
            pst.executeUpdate();
            // 同时获取自增长的id值  一行一列
            rs = pst.getGeneratedKeys();
            if (rs.next()){
                businessId= rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, pst, conn);
        }

        return businessId;
    }
    public int removeBusiness(String businessName){
        return 0;
    }
    public int supdateBusiness(Business business){
        return 0;
    }
    public Business getBusinessById(){
        return null;
    }
}

