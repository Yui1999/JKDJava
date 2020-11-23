package com.company;

import com.company.Dao.impl.BusinessDaoImpl;
import com.company.domain.Business;

import java.util.List;


public class Text {
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
//        int businessid = dao.saveBusiness("江科大食堂");
//        System.out.println("id"+businessid);

//        dao.removeBusiness(10013);

//        Business business = new Business();
//        business.setBusinessName("爆炒钱伦城");
//        business.setBusinessAddress("苏州张家港");
//        business.setBusinessExplain("好吃到爆");
//        business.setStarPrice(15.0);
//        business.setDeliveryPrice(2.0);
//        business.setBusinessId(10011);
//        dao.updateBusiness(business);

//        Business AA = dao.getBusinessById(10011);
//        System.out.println(AA);

        String businessName = "";
        String businessAddress = "";
        List<Business> list =  dao.listBusiness(businessName,businessAddress);
        for (Business e: list){
            System.out.println(e.toString());
        }
    }
}
