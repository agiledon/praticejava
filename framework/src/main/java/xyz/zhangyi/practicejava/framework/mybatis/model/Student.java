package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
public class Student {
    private String id;
    private String name;
    private String email;
    private String mobilePhone;
    private Time registeredTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
