package xyz.zhangyi.practicejava.framework.mybatis.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class WishListServiceTest {
    @Autowired
    private WishListService wishListService;

    @Test
    @Ignore
    public void should_not_exist_in_wishlist() {
        wishListService.add(123, 321);
    }
}