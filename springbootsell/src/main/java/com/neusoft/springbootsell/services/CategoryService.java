package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryService {
    public ProductCategory findOne(Integer categoryId);

    public List<ProductCategory> findAll();

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    public ProductCategory save(ProductCategory productCategory);
}
