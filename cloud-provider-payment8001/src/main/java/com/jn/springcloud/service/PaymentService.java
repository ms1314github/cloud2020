package com.jn.springcloud.service;

import com.jn.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 江南大学1033190417
 * @date 2021/11/20 16:00
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
