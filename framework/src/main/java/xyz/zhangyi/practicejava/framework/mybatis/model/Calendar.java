package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Calendar {
    private int id;
    private int courseId;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private CalendarStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
