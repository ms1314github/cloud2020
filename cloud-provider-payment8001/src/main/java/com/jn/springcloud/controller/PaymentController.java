package com.jn.springcloud.controller;

import com.jn.springcloud.bean.CommonResult;
import com.jn.springcloud.bean.Payment;
import com.jn.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 江南大学1033190417
 * @date 2021/11/20 16:04
 */
@Controller
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    //可以通过服务发现获取该服务的信息
    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    @ResponseBody
    public Object discovery(){
        //获取服务清单列表
        List<String> services=discoveryClient.getServices();
        for (int i = 0; i < services.size(); i++) {
            System.out.println("========service:"+services.get(i));
        }

        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public @ResponseBody String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public @ResponseBody String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public @ResponseBody String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to jn，O(∩_∩)O哈哈~";
    }

}
