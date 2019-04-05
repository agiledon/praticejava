package xyz.zhangyi.practicejava.framework.mybatis;

import xyz.zhangyi.practicejava.framework.mybatis.gateway.MyBatisGateway;
import xyz.zhangyi.practicejava.framework.mybatis.mapper.StudentMapper;
import xyz.zhangyi.practicejava.framework.mybatis.model.Administrator;

import java.util.List;
import java.util.Optional;

public class BlogRepository {
    private MyBatisGateway myBatis = new MyBatisGateway();

    public BlogRepository() {
        myBatis.registerMappers(StudentMapper.class);
    }

    public Optional<Administrator> find(String blogId) {
        return myBatis.executeQuery(session -> {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.selectBlog(blogId);
        });
    }

    public Optional<List<Administrator>> findAll() {
        return myBatis.executeQuery(session -> {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.selectAll();
        });
    }

    public void postBlog(Administrator blog) {
        myBatis.executeCommand(session -> {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.insertBlog(blog);
        });
    }

    public void removeBlog(String blogId) {
        myBatis.executeCommand(session -> {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.deleteBlog(blogId);
        });
    }
}
