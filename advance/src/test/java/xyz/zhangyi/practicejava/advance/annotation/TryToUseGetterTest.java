package xyz.zhangyi.practicejava.advance.annotation;

import org.junit.Test;

public class TryToUseGetterTest {
    @Test
    public void should_generate_getter_and_can_be_used() {
        TryToUseGetter app = new TryToUseGetter("it works");
//        System.out.println(app.getValue());
    }

}