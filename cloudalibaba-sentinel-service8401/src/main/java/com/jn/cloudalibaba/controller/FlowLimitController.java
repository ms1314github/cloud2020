package com.jn.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.omg.CORBA.TIMEOUT;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 江南大学1033190417
 * @date 2021/12/3 11:13
 */

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        System.out.println("一异常比例");
        int age=10/0;

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p2",required = false) String p2){
        //int age=10/0;
        return "------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "----deal_testHotKey┭┮﹏┭┮";
    }
}
