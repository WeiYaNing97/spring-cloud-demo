package com.atguigu.product.service.impl;

import com.atguigu.product.bean.Product;
import com.atguigu.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
    /**
     * 根据给定的ID查询产品信息
     *
     * @param id 要查询的产品ID
     * @return 返回查询到的产品信息对象
     */
    @Override
    public Product selectInformation(Long id) {
        // 创建一个新的Product对象
        Product product = new Product();
        // 设置Product对象的ID属性
        product.setId(id);
        // 设置Product对象的价格属性
        product.setPrice(new BigDecimal("3999"));
        // 设置Product对象的名称属性
        product.setProductName("小米手机");
        // 设置Product对象的数量属性
        product.setNum(100);
        // 返回创建并设置好的Product对象
        return product;
    }

}
