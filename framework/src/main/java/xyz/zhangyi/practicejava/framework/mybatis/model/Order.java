package xyz.zhangyi.practicejava.framework.mybatis.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private Student student;
    private OrderStatus status;
    private Timestamp placedTime;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<OrderItem> orderItems;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public Order(String orderId) {
        this.id = orderId;
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Timestamp getPlacedTime() {
        return placedTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
