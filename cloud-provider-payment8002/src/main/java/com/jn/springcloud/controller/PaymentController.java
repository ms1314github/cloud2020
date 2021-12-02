package com.jn.springcloud.controller;

import com.jn.springcloud.bean.CommonResult;
import com.jn.springcloud.bean.Payment;
import com.jn.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 江南大学1033190417
 * @date 2021/11/20 16:04
 */
@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    @ResponseBody
    public CommonResult create(@RequestBody Payment payment){
        int result= paymentService.create(payment);
        if(result>0){
            return new CommonResult<Integer>(200,"插入成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public @ResponseBody CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment =paymentService.getPaymentById(id);
        CommonResult<Payment> commonResult=new CommonResult<>(200,"查询到,serverPort"+serverPort,payment);
        return commonResult;
    }

    @GetMapping("/payment/lb")
    public @ResponseBody String getPaymentLB(){
        return serverPort;
    }

}
