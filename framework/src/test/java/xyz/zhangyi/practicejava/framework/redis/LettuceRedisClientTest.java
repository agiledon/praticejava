package xyz.zhangyi.practicejava.framework.redis;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LettuceRedisClientTest {
    @Test
    public void should_set_and_get_from_redis() {
        LettuceRedisClient redisClient = new LettuceRedisClient();
        redisClient.set("zy", "http://www.zhangyi.xyz");
        assertThat(redisClient.get("zy")).isEqualTo("http://www.zhangyi.xyz");
    }
}