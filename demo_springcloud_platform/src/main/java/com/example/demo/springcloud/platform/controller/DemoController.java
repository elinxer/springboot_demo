package com.example.demo.springcloud.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author elinx
 */
@Slf4j
@RequestMapping("/demo")
@RestController
public class DemoController {


    @GetMapping("index")
    public String index() {
        log.info("log=={}", "fdsfsdfds");
        return "111111";
    }


}
