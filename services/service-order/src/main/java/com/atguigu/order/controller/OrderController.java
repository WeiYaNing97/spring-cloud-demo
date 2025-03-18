package com.atguigu.order.controller;

import com.atguigu.order.bean.Order;
import com.atguigu.order.service.OrderService;
import com.atguigu.order.yml.OrderYml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope // 刷新配置中心配置 配置中心配置自动刷新
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderYml orderYml;
    @Autowired
    private OrderService orderService;

    /**
     * 可以根据springboot中的方式，直接 读取 Nacos配置文件 中的属性值
     * <p>通过@Value注解，可以直接将配置文件中的属性值注入到Java代码中。</p>
     * 但是 这个时候还不能实现配置中心配置的自动刷新 如果想实现配置中心配置的自动刷新，可以使用@RefreshScope注解
     */
    @Value("${order.timeout}")
    private String orderTimeout;
    @Value("${order.auto-confirm}") // 配置文件中的属性名是order.auto-confirm，所以这里的@Value注解中用的是order.auto-confirm
    private String orderAutoConfirm;

    /**
     * 获取订单配置信息
     *
     * <p>该方法通过访问指定的URL路径（/getConfig）来获取订单配置信息，
     * 并将其打印到控制台。打印的信息包括订单超时时间（orderTimeout）和订单自动确认（orderAutoConfirm）的配置。</p>
     */
    @RequestMapping("/getConfig")
    public void getConfig() {
        // 打印订单配置信息
        // orderTimeout表示订单超时时间，orderAutoConfirm表示订单自动确认
        System.out.println("第一种方式 orderTimeout : " + orderTimeout + " orderAutoConfirm : " + orderAutoConfirm);
        System.out.println("第二种方式 orderTimeout : " + orderYml.getTimeout() + " orderAutoConfirm : " + orderYml.getAutoConfirm());
    }


    /**
     * 获取订单对象
     *
     * <p>通过调用orderService的getPojo方法获取一个Order对象，并返回该对象。
     * 在获取对象后，将对象的信息打印到控制台。</p>
     *
     * @return 返回获取到的Order对象
     */
    @RequestMapping("/getPojo")
    public Order getPojo() {
        // 调用orderService的getPojo方法获取Order对象
        Order pojo = orderService.getPojo();
        // 打印Order对象的信息
        System.out.println(pojo);
        // 返回Order对象
        return pojo;
    }

}
