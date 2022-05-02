package com.jn.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jn.springcloud.bean.CommonResult;
import com.jn.springcloud.bean.Payment;

/**
 * @author 江南大学1033190417
 * @date 2021/12/4 16:00
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "客户自定义,global handlerException", new Payment(2020L, "serial003"));
    }
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "客户自定义,global handlerException2", new Payment(2020L, "serial003"));
    }
}
