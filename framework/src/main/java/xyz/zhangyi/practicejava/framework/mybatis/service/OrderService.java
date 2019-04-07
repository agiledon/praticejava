package xyz.zhangyi.practicejava.framework.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import xyz.zhangyi.practicejava.framework.mybatis.mapper.OrderMapper;
import xyz.zhangyi.practicejava.framework.mybatis.model.Order;

@Component
@Transactional
@EnableTransactionManagement
public class OrderService {
    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public Order getOrder(String orderId) {
        return orderMapper.getOrder(orderId);
    }
}
