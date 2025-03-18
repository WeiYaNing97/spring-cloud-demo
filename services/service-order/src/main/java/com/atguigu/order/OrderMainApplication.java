package com.atguigu.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@EnableFeignClients //开启Feign功能 远程调用
@EnableDiscoveryClient //核心注解 开启服务发现功能
@SpringBootApplication
public class OrderMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager){
        return args -> {
            // 获取ConfigService实例
            ConfigService configService = nacosConfigManager.getConfigService();
            // 为指定的配置文件添加监听器
            configService.addListener(
                    "service-order.yml",  // 配置文件名
                    "DEFAULT_GROUP",     // 配置分组
                    new Listener() {
                        @Override
                        public Executor getExecutor() {
                            // 返回一个固定大小的线程池作为执行器
                            return Executors.newFixedThreadPool(4);
                        }

                        @Override
                        public void receiveConfigInfo(String s) {
                            // 当配置信息发生变化时，打印接收到的配置信息
                            System.out.println("收到配置信息："+s);
                            // 打印邮件通知提示
                            System.out.println("邮件通知。。。。");
                        }
                    }
            );
        };
    };

}