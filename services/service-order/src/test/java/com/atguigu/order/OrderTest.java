package com.atguigu.order;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import com.atguigu.order.bean.Order;
import com.atguigu.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootTest
public class OrderTest {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    private OrderService orderService;


    @Test
    void discoveryClientTest(){
        for (String service : discoveryClient.getServices()) {
            System.out.println("service = " + service);
            //获取ip+port
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip："+instance.getHost()+"；"+"port = " + instance.getPort());
            }
        }
    }


    @Test
    void getPojo() {
        Order pojo = orderService.getPojo();
        System.out.println(pojo);
    }
}
