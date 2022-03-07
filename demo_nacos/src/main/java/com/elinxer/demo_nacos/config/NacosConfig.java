package com.elinxer.demo_nacos.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author elinx
 */
@Data
@RefreshScope // 动态刷新 不一定实时即改即生效，存在一定时间差
@Component // 此配置非正常服务类，需启动注入
public class NacosConfig {

    @Value(value = "${app.demo:1}")
    private String demo;


}
