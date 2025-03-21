package com.atguigu.order.service.impl;

import com.atguigu.order.bean.Order;
import com.atguigu.order.config.OrderRestTemplate;
import com.atguigu.order.feign.ProductFeignClient;
import com.atguigu.order.service.OrderService;
import com.atguigu.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProductFeignClient productFeignClient;

    @Override
    public Order getPojo() {
        // 创建一个新的Order对象
        Order order = new Order();
        // 设置订单的ID
        order.setId(1L);
        // 使用 RestTemplate 获取产品对象
        // 等同于 Product product = restTemplate.getForObject("http://service-product/product/" + order.getId(), Product.class);
        //Product product = getProduct(order.getId());
        // 使用 FeignClient 获取产品对象
        /*
         *使用 三个注解：@EnableFeignClients //开启Feign功能 远程调用
         *            @FeignClient("service-product") //声明调用服务名称
         *            @RequestMapping("/product/{id}") //声明调用服务接口路径 这里用到的是 @GetMapping("/product/{id}") 注解
         */
        Product product = productFeignClient.queryProductById(order.getId());

        /* todo 总金额 */
        // 计算总金额，并设置到订单中
        order.setTotalAAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        // 设置订单的用户ID
        order.setUserId(1L);
        // 设置订单的昵称
        order.setNickName("张三");
        // 设置订单的收货地址
        order.setAddress("北京市");
        /* todo 产品列表 */
        // 将产品对象添加到订单的产品列表中
        order.setProductList(Arrays.asList(product));
        // 返回订单对象
        return order;
    }


    /**
     * 根据产品ID获取产品信息
     *
     * @param id 产品ID
     * @return 获取到的产品信息对象，如果发生异常则返回null
     */
    public Product getProduct(Long id) {
        // 构造访问服务-产品的URL
        String url = "http://service-product/product/" + id;
        try {
            // 使用RestTemplate发送GET请求，并将响应转换为Product对象
            Product forObject = restTemplate.getForObject(url, Product.class);
            // 返回获取到的Product对象
            return forObject;
        } catch (Exception e) {
            // 打印异常堆栈信息
            e.printStackTrace();
            // 处理异常，例如记录错误日志、返回默认产品等
            // Handle the exception, e.g., log the error, return a default product, etc.
            return null;
        }
    }

}
