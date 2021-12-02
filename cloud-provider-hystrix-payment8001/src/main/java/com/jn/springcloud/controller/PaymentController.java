package com.jn.springcloud.controller;

import com.jn.springcloud.service.PaymentService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 江南大学1033190417
 * @date 2021/11/25 21:49
 */
@Controller
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public @ResponseBody String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=paymentService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public @ResponseBody String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result=paymentService.paymentInfo_TimeOut(id);
        return result;
    }


    @GetMapping("/payment/circuit/{id}")
    public @ResponseBody String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }


}
