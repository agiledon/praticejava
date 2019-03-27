package xyz.zhangyi.practicejava.framework.redis;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;

public class LettuceRedisClient {
    public void set(String key, String value) {
        withCommand(connection -> connection.set(key, value));
    }

    public String get(String key) {
        return withCommand(connection -> connection.get(key));
    }

    private <T> T withCommand(RedisCommand<T> command) {
        RedisClient redisClient = new RedisClient(RedisURI.create("redis://127.0.0.1:6379"));
        RedisConnection<String, String> connection = redisClient.connect();
        T result = command.execute(connection);
        connection.close();
        redisClient.shutdown();
        return result;
    }
}
