package com.neusoft.springbootsell.services.Impl;

import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.repository.OrderMasterRepository;
import com.neusoft.springbootsell.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {
    @Autowired
    OrderMasterRepository repository;

    @Override
    public List<OrderMaster> findAll() {
        return repository.findAll();
    }

    @Override
    public void cancel(String orderId) {
        OrderMaster orderMaster = repository.findOne(orderId);
        if (orderMaster.getOrderStatus() == 0){
            orderMaster.setOrderStatus(1);
        }else{
            orderMaster.setOrderStatus(0);
        }
    }

    @Override
    public OrderMaster findById(String orderId) {
        return repository.findOne(orderId);
    }
}
