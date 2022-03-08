package com.elinxer.demo_springboot.domain.vo;

import lombok.Data;

import javax.validation.constraints.*;

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