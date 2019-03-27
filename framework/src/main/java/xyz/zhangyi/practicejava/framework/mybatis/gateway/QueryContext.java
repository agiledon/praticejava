package xyz.zhangyi.practicejava.framework.mybatis.gateway;

import org.apache.ibatis.session.SqlSession;

public interface QueryContext<T> {
    T execute(SqlSession session);
}
