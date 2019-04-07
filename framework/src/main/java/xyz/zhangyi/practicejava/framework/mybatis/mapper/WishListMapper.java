package xyz.zhangyi.practicejava.framework.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

public interface WishListMapper {
    boolean exists(@Param("studentId") int studentId, @Param("courseId") int courseId);

    void insert(@Param("studentId") int studentId, @Param("courseId") int courseId);

    void delete(int studentId, int courseId);
}
