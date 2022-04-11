package com.example.demo.springcloud.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoValidationReq {

    @NotEmpty(message = "email非空")
    private String email;

}
