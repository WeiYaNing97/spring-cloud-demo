package com.atguigu.product.controller;
import com.atguigu.product.bean.Product;
import com.atguigu.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
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
        System.out.println(product.toString());
        // 返回查询到的产品信息
        return product;
    }

}
