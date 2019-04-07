package xyz.zhangyi.practicejava.framework.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class WishListServiceTest {
    @Resource
    private WishListService wishListService;

    @Test
    public void should_not_exist_in_wishlist() {
        wishListService.add(123, 321);
    }
}