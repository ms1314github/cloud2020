package com.jn.springcloud.service;

import com.jn.springcloud.bean.Payment;
import org.springframework.stereotype.Component;

/**
 * @author 江南大学1033190417
 * @date 2021/11/26 0:11
 */
@Component
public class PaymentFallbackService implements PaymentHystirxService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_OK,┭┮﹏┭┮";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_TimeOut,┭┮﹏┭┮";
    }
}
