package xyz.zhangyi.practicejava.framework.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xyz.zhangyi.practicejava.framework.mybatis.model.Blog;

import java.util.List;

public interface BlogMapper {
    @Select("select * from blogs where id = #{id}")
    Blog selectBlog(String id);

    @Select("select * from blogs")
    List<Blog> selectAll();

    @Insert("insert into blogs (id, title, author, post, createdDate) values (#{id}, #{title}, #{author}, #{post}, #{createdDate})")
    void insertBlog(Blog blog);

    @Delete("delete from blogs where id = #{id}")
    void deleteBlog(String id);
}
