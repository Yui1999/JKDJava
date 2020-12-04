package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
