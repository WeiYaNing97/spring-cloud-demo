package com.atguigu.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 自定义的请求拦截器，用于在HTTP请求发送前添加特定的头信息
 * <p>通过实现RequestInterceptor接口，可以在发送HTTP请求之前添加自定义的头部信息或其他拦截逻辑。</p>
 * <p>例如，可以在这里添加一个自定义的请求头X-Token，其值为生成的UUID字符串。</p>
 * <p>通过这种方式，可以在不修改客户端代码的情况下为所有HTTP请求动态添加X-Token头信息。</p>
 */
@Component // 声明为Spring组件，以便自动装配到Spring容器中
public class XTokenRequestInterceptor implements RequestInterceptor {
    /**
     * 重写apply方法，用于在请求发送前添加自定义的拦截逻辑
     *
     * <p>此方法会在每个HTTP请求发送之前被调用，用于添加自定义的请求头或修改请求参数等。</p>
     *
     * @param requestTemplate 请求模板对象，用于构建和发送HTTP请求
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 生成一个唯一的UUID字符串
        String uuid = UUID.randomUUID().toString();
        // 打印拦截器执行的日志信息，包含生成的UUID
        System.out.println("拦截器执行了 " + uuid);
        // 将生成的UUID设置为请求头的X-Token值
        requestTemplate.header("X-Token", uuid);
    }

}
