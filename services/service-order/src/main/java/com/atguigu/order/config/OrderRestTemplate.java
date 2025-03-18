package com.atguigu.order.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderRestTemplate {
    /**
     * 配置RestTemplate
     *
     * @Bean 让Spring管理这个bean
     *
     * @LoadBalanced 解决RestTemplate调用服务提供者地址时，不带服务名问题
     * 还可以负载均衡调用服务提供者地址
     * @return
     */

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


    /**
     * 配置Feign的日志级别为FULL
     *
     * @return 返回Feign的日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


    @Bean
    Retryer retryer(){
        return new Retryer.Default();
    }
}
