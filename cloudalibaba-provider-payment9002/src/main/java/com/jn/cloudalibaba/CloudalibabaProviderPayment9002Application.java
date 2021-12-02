package com.jn.cloudalibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.jn.cloudalibaba.mapper")
public class CloudalibabaProviderPayment9002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderPayment9002Application.class, args);
    }

}
