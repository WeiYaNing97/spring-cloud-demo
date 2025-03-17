package com.atguigu.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //核心注解
@SpringBootApplication
public class ProdutMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdutMainApplication.class, args);
    }

}