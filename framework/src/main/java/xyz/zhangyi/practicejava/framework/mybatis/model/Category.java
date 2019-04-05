package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private int id;
    private int courseId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
