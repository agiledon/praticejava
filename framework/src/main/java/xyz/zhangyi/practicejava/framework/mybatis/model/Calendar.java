package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class Calendar {
    private int id;
    private int courseId;
    private String place;
    private Date startDate;
    private Date endDate;
    private CalendarStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
