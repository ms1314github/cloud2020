package com.jn.springcloud.controller;

import com.jn.springcloud.bean.CommonResult;
import com.jn.springcloud.service.PaymentFeignService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 江南大学1033190417
 * @date 2021/11/25 17:02
 */
@Controller
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public @ResponseBody
    CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public @ResponseBody String paymentFeignTimeout(){
        //openfeign-ribbon,客户端默认等待1秒
        return paymentFeignService.paymentFeignTimeout();
    }
}
