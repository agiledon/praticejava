package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Student {
    private int id;
    private String name;
    private String email;
    private String mobilePhone;
    private LocalTime registeredTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
