package com.jn.springcloud.service;

import com.jn.springcloud.domain.Order;

/**
 * @author 江南大学1033190417
 * @date 2021/12/5 17:59
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
