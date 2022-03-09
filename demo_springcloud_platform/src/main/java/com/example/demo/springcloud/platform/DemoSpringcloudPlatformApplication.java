package com.example.demo.springcloud.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author elinx
 */
@ComponentScan(value = {"com.example", "com.elinxer.springcloud.platform.core"})
@SpringBootApplication
public class DemoSpringcloudPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringcloudPlatformApplication.class, args);
    }

}
