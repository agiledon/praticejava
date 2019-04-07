package xyz.zhangyi.practicejava.framework.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class OrderServiceTest {
    @Resource
    private OrderService orderService;

    @Test
    public void should_get_order_by_id() {
        orderService.getOrder(1);
    }

}