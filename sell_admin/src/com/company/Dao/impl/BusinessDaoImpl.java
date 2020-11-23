package com.company.Dao.impl;

import com.company.domain.Business;
import com.company.utils.JDBCUtil;
import com.company.Dao.BusinessDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao{
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        ArrayList<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business WHERE 1=1");
        if(businessName != null && !businessName.equals("")){
            sql.append("and businessName LIKE '%"+businessName+"%'");
        }
        if(businessAddress != null && !businessAddress.equals("")){
            sql.append("and businessAddress like '%"+businessAddress+"%'");
        }
//        System.out.println("sql ="+sql.toString());
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt(1));
                business.setPassword(rs.getString(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStarPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));
                list.add(business);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
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

    /**
     * 删除商家
     * @param businessId 商家id
     * @return 0代表删除失败 1 代表删除成功
     */
    @Override
    public int removeBusiness(int businessId) {
        int result = 0;
        String sql = "delete from business where businessId = ?";
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setInt(1,businessId);
            result = pst.executeUpdate();
            conn.commit();
        }catch (Exception e){
            result = 0;
            try{
                conn.rollback();
            }catch(SQLException throwables){
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.close(pst,conn);
        }
        return result;
    }

    /**
     *修改商家
     * @param business
     * @return
     */
    @Override
    public int updateBusiness(Business business){
        int result = 0;
        String sql = "update business set businessName = ?,businessAddress = ?,businessExplain = ?,starPrice = ?,deliveryPrice = ? where businessId = ?";
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,business.getBusinessName());
            pst.setString(2,business.getBusinessAddress());
            pst.setString(3,business.getBusinessExplain());
            pst.setDouble(4,business.getStarPrice());
            pst.setDouble(5,business.getDeliveryPrice());
            pst.setInt(6,business.getBusinessId());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过Id查询商家
     * @return
     */
    @Override
    public Business getBusinessById(Integer businessId){
        Business business = null;
        String sql = "select * from business where businessId = ?";
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,businessId);
            rs = pst.executeQuery();
            while(rs.next()){
                business = new Business();
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setBusinessId(rs.getInt("businessId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pst,conn);
        }
        return business;
    }

    @Override
    public Business getBusinessByIdAndPassword(Integer businessId, String password) {
        Business business = null;
        String sql = "select * from business where businessId = ? and password = ? ";

        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, businessId);
            pst.setString(2, password);
            rs = pst.executeQuery();

            while (rs.next()){
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, pst, conn);
        }
        return business;
    }
}

