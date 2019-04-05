package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderItem {
    private int id;
    private int orderId;
    private int trainingId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
