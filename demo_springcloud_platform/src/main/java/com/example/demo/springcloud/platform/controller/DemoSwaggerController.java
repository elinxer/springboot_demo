package com.example.demo.springcloud.platform.controller;

import com.elinxer.springcloud.platform.core.annotation.MethodRequestParamLog;
import com.elinxer.springcloud.platform.core.web.response.Response;
import com.example.demo.springcloud.platform.domain.DemoValidationReq;
import com.example.demo.springcloud.platform.service.IDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * http://127.0.0.1:8103/demo-swagger/index
 *
 * 
 *
 * @author elinx
 */
@Api(value = "swagger此值要唯一", tags = "swagger")
@Slf4j
@RequestMapping("/demo-swagger")
@RestController
public class DemoSwaggerController {

    @Autowired
    IDemoService iDemoService;


    @ApiOperation(value = "index", notes = "index")
    @GetMapping("index")
    @MethodRequestParamLog
    public Response<String> index3(@RequestBody @Valid DemoValidationReq req) {
        return Response.ok("email=" + req.toString());
    }


}
