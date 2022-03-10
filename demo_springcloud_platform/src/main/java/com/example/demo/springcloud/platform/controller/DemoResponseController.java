package com.example.demo.springcloud.platform.controller;

import com.elinxer.springcloud.platform.core.annotation.ResponseResultWrapper;
import com.example.demo.springcloud.platform.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author elinx
 */
@Slf4j
@RequestMapping("/demo-response")
@RestController
@ResponseResultWrapper
public class DemoResponseController {

    @Autowired
    IDemoService iDemoService;

    @GetMapping("index")
    public String index() {
        return "1111121";
    }


}
