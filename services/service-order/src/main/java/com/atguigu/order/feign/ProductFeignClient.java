package com.atguigu.order.feign;

import com.atguigu.order.feign.fallback.ProductFeignClientFallback;
import com.atguigu.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 我的理解：
 * 远程调用实现方法 类似于 一个service接口，但是不需要写接口的实现类。
 * 添加@FeignClient(value = "service-product"）注解，表明这是一个远程调用的客户端。使用Restful风格的请求方式，调用远程服务即可。
 *
 *
 * FeignClient是Spring Cloud中的一个组件，用于实现微服务之间的远程调用。 通过FeignClient，我们可以像调用本地方法一样去调用远程服务。
 * 1、FeignClient注解标注在接口上，表明这是一个远程调用的客户端
 * 2、@FeignClient注解的value属性，表明调用的是哪一个服务
 * 3、fallback属性，表明当远程调用失败时，使用哪一个类作为降级处理 (兜底逻辑)
 * 4、@GetMapping注解标注在方法上，表明这是一个远程调用的请求
 */
@FeignClient(value = "service-product",fallback = ProductFeignClientFallback.class) // 服务名
public interface ProductFeignClient {

    //mvc注解的两套使用逻辑
    //1、标注在Controller上，是接受这样的请求
    //2、标注在FeignClient上，是发送这样的请求
    @GetMapping("/product/{id}")
    Product queryProductById(@PathVariable("id") Long id);

}
