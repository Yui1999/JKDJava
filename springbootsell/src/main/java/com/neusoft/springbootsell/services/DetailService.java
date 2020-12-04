package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.OrderDetail;

public interface DetailService {
    public OrderDetail findByOrderId(String detailId);
}