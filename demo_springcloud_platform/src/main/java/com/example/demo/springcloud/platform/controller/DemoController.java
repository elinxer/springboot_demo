package com.example.demo.springcloud.platform.controller;

import com.elinxer.springcloud.platform.core.web.response.Response;
import com.elinxer.springcloud.platform.core.annotation.MethodRequestParamLog;
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
@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    IDemoService iDemoService;

    @GetMapping("index")
    public String index() {
        log.info("log=={}", "fdsfsdfds");
        return "111111";
    }

    @GetMapping("index2")
    public Response<String> index2() {
        return Response.error("Error");
    }

    @GetMapping("index3")
    @MethodRequestParamLog
    public Response<String> index3(String path, String path2) {
        return Response.ok("MethodRequestParamLog");
    }

    @GetMapping("index4")
    public Response<String> index4(String path, String test) {
        iDemoService.demoParam(path, test);
        return Response.ok("MethodRequestParamLog");
    }

}
