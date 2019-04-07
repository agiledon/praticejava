package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderItem {
    private String id;
    private String orderId;
    private Training training;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
