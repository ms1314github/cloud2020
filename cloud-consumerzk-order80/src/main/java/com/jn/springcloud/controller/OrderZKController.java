package com.jn.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author 江南大学1033190417
 * @date 2021/11/23 21:55
 */
@Controller
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL="http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/zk")
    @ResponseBody
    public String paymentInfo(){
        String result=restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return result;
    }
}
