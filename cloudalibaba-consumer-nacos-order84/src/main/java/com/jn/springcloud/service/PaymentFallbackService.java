package com.jn.springcloud.service;

import com.jn.springcloud.bean.CommonResult;
import com.jn.springcloud.bean.Payment;
import org.springframework.stereotype.Component;

/**
 * @author 江南大学1033190417
 * @date 2021/12/4 23:35
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult paymentSQL(Long id) {

        return new CommonResult(444, "服务降级返回，-----PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
