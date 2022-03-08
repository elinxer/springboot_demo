package com.elinxer.demo_springboot.controllerdemo.controller;

import com.elinxer.demo_springboot.controllerdemo.domain.vo.DemoPostJsonReqVo;
import com.elinxer.demo_springboot.controllerdemo.domain.vo.DemoPostJsonValidReqVo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author elinx
 */
@RequestMapping("/controllerdemo")
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
