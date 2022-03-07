package com.elinxer.demo_nacos.feign.callback;

import com.elinxer.demo_nacos.feign.DemoFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author yangzhen
 * @date 2021/10/9
 */
@Component
public class DemoFeignClientFallback implements DemoFeignClient {

    @Override
    public String index(){
        System.out.println("error!");
        return "error";
    }


}
