package com.atguigu.order.yml;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Component
@ConfigurationProperties(prefix = "order") //配置绑定在nacos下，可以无需@RefreshScope
public class OrderYml {

    @Value("${order.timeout}")
    String timeout;
    @Value("${order.auto-confirm}")
    String autoConfirm;

}
