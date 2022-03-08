package com.elinxer.demo_springboot.controllerdemo.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author elinx
 */
@Data
public class DemoPostJsonValidReqVo {

    @NotEmpty(message = "参数不能为空")
    private String test;

    @NotNull(message = "参数不能为空")
    private Integer num;


}