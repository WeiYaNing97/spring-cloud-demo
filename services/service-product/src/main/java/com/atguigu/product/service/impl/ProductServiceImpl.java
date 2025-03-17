package com.atguigu.product.service.impl;

import com.atguigu.product.bean.Product;
import com.atguigu.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product selectInformation(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("3999"));
        product.setProductName("小米手机");
        product.setNum(100);
        return product;
    }
}
