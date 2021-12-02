package com.jn.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 江南大学1033190417
 * @date 2021/11/20 17:24
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
    //@LoadBalanced//开启负载均衡，默认轮训负载机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
