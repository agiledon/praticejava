package xyz.zhangyi.practicejava.framework.mybatis.gateway;

import org.apache.ibatis.session.SqlSession;

public interface CommandContext {
    void execute(SqlSession session);
}
