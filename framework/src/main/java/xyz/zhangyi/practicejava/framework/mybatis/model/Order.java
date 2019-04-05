package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private int id;
    private int studentId;
    private OrderStatus status;
    private LocalDateTime placedTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
