package com.jn.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.jn.springcloud.mapper")
public class CloudProviderPayment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8002Application.class, args);
    }

}
