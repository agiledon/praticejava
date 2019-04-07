package xyz.zhangyi.practicejava.framework.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.zhangyi.practicejava.framework.mybatis.model.Order;
import xyz.zhangyi.practicejava.framework.mybatis.model.OrderStatus;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class OrderServiceTest {
    @Resource
    private OrderService orderService;

    @Test
    public void should_get_order_by_id() {
        Order order = orderService.getOrder("order000-4100-45c5-86c7-6ca57e0f0001");
        assertThat(order.getId()).isEqualTo("order000-4100-45c5-86c7-6ca57e0f0001");
        assertThat(order.getStatus()).isEqualTo(OrderStatus.New);
        assertThat(order.getOrderItems().size()).isEqualTo(2);
    }

}