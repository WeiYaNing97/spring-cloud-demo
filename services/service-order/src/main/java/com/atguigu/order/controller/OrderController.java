package com.atguigu.order.controller;

import com.atguigu.order.bean.Order;
import com.atguigu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/getPojo")
    public Order getPojo() {
        Order pojo = orderService.getPojo();
        System.out.println(pojo);
        return pojo;
    }
}
