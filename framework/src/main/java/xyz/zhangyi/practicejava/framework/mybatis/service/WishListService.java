package xyz.zhangyi.practicejava.framework.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import xyz.zhangyi.practicejava.framework.mybatis.mapper.WishListMapper;

@Component
@Transactional
@EnableTransactionManagement
public class WishListService {
    private WishListMapper wishListMapper;

    @Autowired
    public void setWishListMapper(WishListMapper wishListMapper) {
        this.wishListMapper = wishListMapper;
    }

    public void add(int studentId, int courseId) {
        if (wishListMapper.exists(studentId, courseId)) return;
        wishListMapper.insert(studentId, courseId);
    }
}
