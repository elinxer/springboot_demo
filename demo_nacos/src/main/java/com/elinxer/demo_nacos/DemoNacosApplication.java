package com.elinxer.demo_nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author elinx
 */
@EnableFeignClients // 启动feign客户端调用
//@EnableFeignClients(basePackages = "com.hx") //如果无法发现第三方包的feign，需要加入包扫描
@EnableDiscoveryClient // 想要注册和被调用，需要启动服务发现
@SpringBootApplication
public class DemoNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoNacosApplication.class, args);
    }

}
