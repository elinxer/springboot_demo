package com.elinxer.demo_springboot.aopdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elinxer.demo_springboot.aopdemo.annotation.PermissionAnnotation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Elinx<yangdongsheng03>
 */
@RestController
@RequestMapping("/PermissionsAnnotation")
public class PermissionsAnnotation {

    @PermissionAnnotation()
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public JSONObject getGroupList(@RequestBody JSONObject request) {

        // request content
        // post raw
        // Content-Type:application/json
        // {"id": "123"}

        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }

}
