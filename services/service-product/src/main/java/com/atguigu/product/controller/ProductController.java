package com.atguigu.product.controller;
import com.atguigu.product.bean.Product;
import com.atguigu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getInformation(@PathVariable("id") Long id){
        Product product = productService.selectInformation(id);
        System.out.println(product.toString());
        return product;
    }
}
