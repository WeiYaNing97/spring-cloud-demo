package com.atguigu.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

// 使用FeignClient注解，指定外部服务的名称和地址
// 这里的value可以随便写，但是url要和外部服务的地址一致
@FeignClient(value = "weather-client",url = "http://aliv18.data.moji.com")
public interface WeatherFeignClient {
    @PostMapping("/whapi/json/alicityweather/condition") // 这里的路径要和外部服务的接口一致
    String getWeather(@RequestHeader("Authorization") String Authorization,
                      @RequestParam("token") String token,
                      @RequestParam("cityid") String cityid);

}
