package xyz.zhangyi.practicejava.advance.java8.lambda;

import org.junit.Test;

import java.util.List;

public class OrchardTest {
    @Test
    public void should_filter_with_green_color() {
        Orchard orchard = new Orchard();
        List<Apple> apples = orchard.filterGreenApples();

        apples.forEach(System.out::println);

    }
}