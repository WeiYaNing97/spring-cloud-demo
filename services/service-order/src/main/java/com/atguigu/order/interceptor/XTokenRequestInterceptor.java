package com.atguigu.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class XTokenRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String uuid = UUID.randomUUID().toString();
        System.out.println("拦截器执行了 " + uuid);
        requestTemplate.header("X-Token", uuid);
    }
}
