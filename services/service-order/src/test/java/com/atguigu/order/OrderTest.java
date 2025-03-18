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


    /**
     * 测试服务发现功能
     *
     * 通过discoveryClient获取服务注册中心中的所有服务，并打印每个服务的名称和对应的实例信息（IP地址和端口号）
     */
    @Test
    void discoveryClientTest(){
        // 遍历服务注册中心中的所有服务
        for (String service : discoveryClient.getServices()) {
            // 打印服务名称
            System.out.println("service = " + service);
            // 获取当前服务的所有实例
            //获取ip+port
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            // 遍历当前服务的所有实例
            for (ServiceInstance instance : instances) {
                // 打印每个实例的IP地址和端口号
                System.out.println("ip："+instance.getHost()+"；"+"port = " + instance.getPort());
            }
        }
    }



    /**
     * 测试获取Order对象的方法
     *
     * <p>该方法用于测试从orderService中获取Order对象，并打印该对象的信息。</p>
     */
    @Test
    void getPojo() {
        // 调用orderService的getPojo方法获取Order对象
        Order pojo = orderService.getPojo();
        // 打印Order对象的信息
        System.out.println(pojo);
    }

}
