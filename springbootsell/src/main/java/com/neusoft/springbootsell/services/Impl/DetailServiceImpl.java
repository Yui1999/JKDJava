package com.neusoft.springbootsell.services.Impl;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.repository.OrderDetailRepository;
import com.neusoft.springbootsell.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    OrderDetailRepository repository;
    @Override
    public OrderDetail findByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }
}
