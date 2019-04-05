package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Training {
    private int id;
    private int studentId;
    private int calendarId;
    private double price;
    private LocalDateTime subscribedTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
