package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.OrderMaster;

import java.util.List;

public interface MasterService {
    public List<OrderMaster> findAll();
    public void cancel(String orderId);
    public OrderMaster findById(String orderId);
}
