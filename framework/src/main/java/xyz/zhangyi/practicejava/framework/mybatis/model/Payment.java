package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Payment {
    private int id;
    private int studentId;
    private int orderId;
    private double amount;
    private String paymentStyle;
    private PaymentStatus status;
    private LocalDateTime transactionTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
