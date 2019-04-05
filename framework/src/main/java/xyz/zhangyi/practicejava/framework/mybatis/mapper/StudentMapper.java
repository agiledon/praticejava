package xyz.zhangyi.practicejava.framework.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xyz.zhangyi.practicejava.framework.mybatis.model.Administrator;

import java.util.List;

public interface StudentMapper {
    @Select("select * from blogs where id = #{id}")
    Administrator selectBlog(String id);

    @Select("select * from blogs")
    List<Administrator> selectAll();

    @Insert("insert into blogs (id, title, author, post, createdDate) values (#{id}, #{title}, #{author}, #{post}, #{createdDate})")
    void insertBlog(Administrator blog);

    @Delete("delete from blogs where id = #{id}")
    void deleteBlog(String id);
}
