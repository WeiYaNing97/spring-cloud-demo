package com.atguigu.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient注解的参数：
 * value：外部服务的名称 (可以随便写一个，默认是服务名)
 * url：外部服务的地址 (要和外部服务的地址一致)
 *
 */
@FeignClient(value = "weather-client",url = "http://aliv18.data.moji.com")
public interface WeatherFeignClient {
    /**
     * 获取天气信息
     *
     * <p>通过调用外部天气服务接口，获取指定城市的天气信息。</p>
     *
     * @param Authorization 请求头中的Authorization字段，用于身份验证
     * @param token 请求参数中的token字段，用于接口调用权限验证
     * @param cityid  请求参数中的cityid字段，表示要查询天气的城市ID
     * @return 返回的天气信息字符串
     */
    @PostMapping("/whapi/json/alicityweather/condition") // 这里的路径要和外部服务的接口一致
    String getWeather(@RequestHeader("Authorization") String Authorization,
                      @RequestParam("token") String token,
                      @RequestParam("cityid") String cityid);

}
