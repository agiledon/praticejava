package xyz.zhangyi.practicejava.framework.redis;

import com.lambdaworks.redis.RedisConnection;

public interface RedisCommand<T> {
    T execute(RedisConnection<String, String> connection);
}
