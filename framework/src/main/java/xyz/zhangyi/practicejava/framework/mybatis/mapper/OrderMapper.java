package xyz.zhangyi.practicejava.framework.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.zhangyi.practicejava.framework.mybatis.model.Order;

public interface OrderMapper {
    Order getOrder(@Param("orderId") int orderId);
}
