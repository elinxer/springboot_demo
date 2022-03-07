package com.elinxer.demo_nacos.controller;

import com.elinxer.demo_nacos.feign.DemoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://127.0.0.1:8101/demo-nacos/feign/index
 *
 * @author elinx
 */
@RequestMapping("/feign")
@RestController
public class FeignController {

    @Autowired
    DemoFeignClient demoFeignClient;

    @GetMapping("/index")
    public String index() {
        return "from openfeign=" + demoFeignClient.index();
    }


}
