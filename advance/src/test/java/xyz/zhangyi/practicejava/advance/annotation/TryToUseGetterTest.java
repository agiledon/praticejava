package xyz.zhangyi.practicejava.advance.annotation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryToUseGetterTest {
    @Test
    public void should_generate_getter_and_can_be_used() {
        TryToUseGetter app = new TryToUseGetter("it works");
        assertThat(app.getValue()).isEqualToIgnoringCase("it works");
    }

}