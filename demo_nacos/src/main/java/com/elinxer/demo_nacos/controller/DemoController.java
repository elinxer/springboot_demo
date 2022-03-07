package com.elinxer.demo_nacos.controller;

import com.elinxer.demo_nacos.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://127.0.0.1:8101/demo-nacos/demo/index
 *
 * @author elinx
 */
@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    NacosConfig config;

    @GetMapping("/index")
    public String index() {
        return config.getDemo();
    }



}
