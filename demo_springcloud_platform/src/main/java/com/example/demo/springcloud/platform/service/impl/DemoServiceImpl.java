package com.example.demo.springcloud.platform.service.impl;

import com.elinxer.springcloud.platform.core.annotation.MethodRequestParamLog;
import com.example.demo.springcloud.platform.service.IDemoService;
import org.springframework.stereotype.Service;

/**
 * @author elinx
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Override
    @MethodRequestParamLog
    public String demoParam(String path, String test) {
        return "demoParam=" + path + "; test=" + test;
    }

}
