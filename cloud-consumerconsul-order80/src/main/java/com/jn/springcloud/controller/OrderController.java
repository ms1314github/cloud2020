package com.jn.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author 江南大学1033190417
 * @date 2021/11/23 23:18
 */
@Controller
public class OrderController {
    public static final String INVOKE_URL = "http://consul-provider-payment";


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public @ResponseBody
    String paymentConsul() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }

}
