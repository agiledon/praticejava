package xyz.zhangyi.practicejava.strings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static xyz.zhangyi.practicejava.strings.StringHelper.toStringHelper;

public class StringHelperTest {

    private final User user = new User("zhangyi", 43);

    @Test
    public void should_output_class_type_name() {
        String output = toStringHelper(user).toString();

        assertThat(output).isEqualTo("Class is xyz.zhangyi.practicejava.strings.User\n");
    }

    @Test
    public void should_add_one_field_info() {
        String output = toStringHelper(user)
                .add("name", user.getName())
                .toString();

        assertThat(output)
                .startsWith("Class is")
                .contains("name: zhangyi");
    }

    @Test
    public void should_add_two_field_info() {
        String output = toStringHelper(user)
                .add("name", user.getName())
                .add("age", user.getAge())
                .toString();

        assertThat(output).isEqualTo(expectedUserInfo());
    }

    @Test
    public void should_output_user_info_using_by_StringHelper() {
        assertThat(user.toString()).isEqualTo(expectedUserInfo());
    }

    private String expectedUserInfo() {
        return "Class is xyz.zhangyi.practicejava.strings.User\n"
                + "name: zhangyi\n"
                + "age: 43\n";
    }
}
