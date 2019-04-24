package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Administrator {
    private String id;
    private String name;
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
