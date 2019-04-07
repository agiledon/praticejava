package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Teacher {
    private String id;
    private String name;
    private String organization;
    private String title;
    private String profile;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
