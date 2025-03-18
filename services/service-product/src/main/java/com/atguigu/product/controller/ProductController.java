package com.atguigu.product.controller;
import com.atguigu.product.bean.Product;
import com.atguigu.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 读取配置文件的第一种方式：通过@Value注解读取配置文件中的属性值 加 @RefreshScope注解 实现配置中心配置的自动刷新
     *
     * 可以根据springboot中的方式，直接 读取 Nacos配置文件 中的属性值
     * <p>通过@Value注解，可以直接将配置文件中的属性值注入到Java代码中。</p>
     * 但是 这个时候还不能实现配置中心配置的自动刷新 如果想实现配置中心配置的自动刷新，可以使用@RefreshScope注解
     */
    @Value("${int.num}")
    String intnum;
    @Value("${int.sum}")
    String intsum;

    /**
     * 根据给定的ID获取产品信息
     *
     * @param id 产品ID
     * @param request HttpServletRequest对象，用于获取请求头信息
     * @return 返回查询到的产品信息
     */
    @GetMapping("/{id}")
    public Product getInformation(@PathVariable("id") Long id,
                                  HttpServletRequest request){
        // 获取请求头中的X-Token值
        String header = request.getHeader("X-Token");
        // 打印X-Token值
        System.out.println(header);
        // 调用productService的selectInformation方法，根据id查询产品信息
        Product product = productService.selectInformation(id);
        // 打印查询到的产品信息
        System.out.println(product.toString()+"直接 intnum "+intnum+" intsum "+intsum);
        // 返回查询到的产品信息
        return product;
    }

}
