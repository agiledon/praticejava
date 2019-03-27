package xyz.zhangyi.practicejava.framework.mybatis;

import xyz.zhangyi.practicejava.framework.mybatis.gateway.MyBatisGateway;
import xyz.zhangyi.practicejava.framework.mybatis.mapper.BlogMapper;
import xyz.zhangyi.practicejava.framework.mybatis.model.Blog;

import java.util.List;
import java.util.Optional;

public class BlogRepository {
    private MyBatisGateway myBatis = new MyBatisGateway();

    public BlogRepository() {
        myBatis.registerMappers(BlogMapper.class);
    }

    public Optional<Blog> find(String blogId) {
        return myBatis.executeQuery(session -> {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            return mapper.selectBlog(blogId);
        });
    }

    public Optional<List<Blog>> findAll() {
        return myBatis.executeQuery(session -> {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            return mapper.selectAll();
        });
    }

    public void postBlog(Blog blog) {
        myBatis.executeCommand(session -> {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            mapper.insertBlog(blog);
        });
    }

    public void removeBlog(String blogId) {
        myBatis.executeCommand(session -> {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            mapper.deleteBlog(blogId);
        });
    }
}
