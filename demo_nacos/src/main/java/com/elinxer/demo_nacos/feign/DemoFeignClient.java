package com.elinxer.demo_nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author elinx
 */
@FeignClient(value = "demo-nacos", path = "/demo-nacos/demo") //注册中心中显示的微服务名称
//@FeignClient(contextId = "DemoFeignClient", // 自定义唯一ID
//        value = "demo-nacos", //注册中心中显示的微服务名称
//        path = "/demo-nacos/demo", // 需要调用的api路径
//        configuration = GlobalFeignConfig.class,
//        fallbackFactory = DemoFeignClientFallback.class, // 错误回调处理类
//        decode404 = true)
public interface DemoFeignClient {

    @GetMapping("/index")
    String index();

}
