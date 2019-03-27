package xyz.zhangyi.practicejava.advance.java8.optional.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonTest {

    private String userJsonStr = "{\"age\":40,\"name\":\"zhangyi\"}";

    @Test
    public void should_parse_java_object_to_string() {
        User user = new User("zhangyi", 40);
        String result = Json.toJsonString(user);

        assertThat(result).isEqualTo(userJsonStr);
    }

    @Test
    public void should_parse_string_to_java_object() {
        User user = new User("zhangyi", 40);
        User result = Json.toJavaObject(Json.parse(userJsonStr), User.class);

        assertThat(result.getName()).isEqualTo(user.getName());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class User {
        private String name;
        private int age;
    }
}