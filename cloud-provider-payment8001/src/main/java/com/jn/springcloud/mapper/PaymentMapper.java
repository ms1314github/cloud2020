package com.jn.springcloud.mapper;

import com.jn.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 江南大学1033190417
 * @date 2021/11/20 15:51
 */
public interface PaymentMapper {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
