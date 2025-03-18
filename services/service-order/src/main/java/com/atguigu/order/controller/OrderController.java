package com.atguigu.order.controller;

import com.atguigu.order.bean.Order;
import com.atguigu.order.service.OrderService;
import com.atguigu.order.yml.OrderYml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope // 刷新配置中心配置 配置中心配置自动刷新
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderYml orderYml;
    @Autowired
    private OrderService orderService;

    /*@Value("${order.timeout}")
    private String orderTimeout;
    @Value("${order.autoConfirm}")
    private String orderAutoConfirm;*/

    @RequestMapping("/getConfig")
    public void getConfig() {
        System.out.println("orderTimeout : "+orderYml.getTimeout() + " orderAutoConfirm : " + orderYml.getAutoConfirm());
    }

    @RequestMapping("/getPojo")
    public Order getPojo() {
        Order pojo = orderService.getPojo();
        System.out.println(pojo);
        return pojo;
    }
}
