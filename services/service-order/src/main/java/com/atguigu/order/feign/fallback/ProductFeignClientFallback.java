package com.atguigu.order.feign.fallback;

import com.atguigu.order.feign.ProductFeignClient;
import com.atguigu.product.bean.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 我的理解：
 * 1、兜底回调的 作用是：当远程调用失败时，兜底回调会执行
 * 2、兜底回调的实现方式类似于 serviceImpl 的实现方式，只不过兜底回调的实现类上标注了 @Component 注解
 *    ：@FeignClient(value = "service-product",fallback = ProductFeignClientFallback.class) // 服务名
 *      public interface ProductFeignClient {}
 *      @Component
 *      public class ProductFeignClientFallback implements ProductFeignClient { // 实现接口 兜底回调的实现类
 *          @Override
 *          public Product queryProductById(Long id) { // 实现方法 兜底回调的实现方法
 *              System.out.println("兜底回调....");
 *              return null;
 *          }
 *      }
 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    /**
     * 根据产品ID查询产品信息，如果未找到则返回默认信息
     *
     * @param id 产品ID
     * @return 返回对应的产品对象，如果未找到则返回默认产品对象
     */
    @Override
    public Product queryProductById(Long id) {
        // 打印兜底回调信息
        System.out.println("兜底回调....");
        // 创建一个新的Product对象
        Product product = new Product();
        // 设置Product对象的ID属性
        product.setId(id);
        // 设置Product对象的价格属性为0
        product.setPrice(new BigDecimal("0"));
        // 设置Product对象的名称属性为"未知商品"
        product.setProductName("未知商品");
        // 设置Product对象的数量属性为0
        product.setNum(0);
        // 返回创建并设置好的Product对象
        return product;
    }

}
