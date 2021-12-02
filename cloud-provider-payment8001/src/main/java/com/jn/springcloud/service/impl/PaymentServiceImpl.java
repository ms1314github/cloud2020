package com.jn.springcloud.service.impl;

import com.jn.springcloud.bean.Payment;
import com.jn.springcloud.mapper.PaymentMapper;
import com.jn.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 江南大学1033190417
 * @date 2021/11/20 16:01
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
