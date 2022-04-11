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
 * http://127.0.0.1:8103/demo-validation/index
 *
 * @author elinx
 */
@Api(value = "农场用户管理", tags = "农场-员工管理")
@Slf4j
@RequestMapping("/demo-validation")
@RestController
public class DemoValidationController {

    @Autowired
    IDemoService iDemoService;


    @ApiOperation(value = "农场员工管理-分页查询", notes = "包含角色用户")
    @GetMapping("index")
    @MethodRequestParamLog
    public Response<String> index3(@RequestBody @Valid DemoValidationReq req) {
        return Response.ok("email=" + req.toString());
    }


}
