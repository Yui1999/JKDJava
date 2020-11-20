package com.company;

import com.company.Dao.impl.BusinessDaoImpl;

public class Text {
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        int businessid = dao.saveBusiness("江科大食堂");
        System.out.println("id"+businessid);
    }
}
