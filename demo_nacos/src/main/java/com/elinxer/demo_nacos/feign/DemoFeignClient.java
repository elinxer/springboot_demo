package com.elinxer.demo_nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author elinx
 */
@FeignClient(value = "demo-nacos", path = "/demo-nacos/demo") //注册中心中显示的微服务名称
public interface DemoFeignClient {

    @GetMapping("/index")
    String index();

}
