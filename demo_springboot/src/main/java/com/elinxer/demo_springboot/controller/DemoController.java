package com.elinxer.demo_springboot.controller;

import com.elinxer.demo_springboot.domain.vo.DemoPostJsonReqVo;
import com.elinxer.demo_springboot.domain.vo.DemoPostJsonValidReqVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * @author elinx
 */
@RequestMapping("/demo")
@RestController
public class DemoController {


    @GetMapping("/getIndex")
    public String getIndex() {
        return "getIndex";
    }

    @GetMapping("/getIndexPath/{path}")
    public String getIndexPath(@PathVariable String path) {
        return "getIndexPath=" + path;
    }

    @GetMapping("/getIndexParam")
    public String getIndexParam(String path) {
        return "getIndexParam=" + path;
    }

    @PostMapping("/postIndex")
    public String postIndex() {
        return "postIndex";
    }

    @PostMapping("/postIndexParam")
    public String postIndexParam(String path) {
        return "postIndexParam=" + path;
    }

    @PostMapping("/postIndexParamValid")
    public String postIndexParamValid(@RequestParam(value = "", name = "path", required = true) String path) {
        return "postIndexParam=" + path;
    }

    @PostMapping("/postIndexJson")
    public String postIndexJson(@RequestBody DemoPostJsonReqVo reqVo) {
        return "postIndexJson=" + reqVo.toString();
    }

    @PostMapping("/postIndexJsonValid")
    public String postIndexJsonValid(@RequestBody @Valid DemoPostJsonValidReqVo reqVo) {
        return "postIndexJson=" + reqVo.toString();
    }

}
