package xyz.zhangyi.practicejava.advance.annotation;

import org.junit.Test;

public class HelloAppTest {
    @Test
    public void should_hello() {
        HelloApp helloApp = new HelloApp();
        helloApp.print();
    }
}