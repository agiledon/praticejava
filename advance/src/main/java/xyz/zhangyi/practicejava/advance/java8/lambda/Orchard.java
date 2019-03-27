package xyz.zhangyi.practicejava.advance.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Orchard {
    private List<Apple> apples = Arrays.asList(
            new Apple("red", 120),
            new Apple("green", 160),
            new Apple("red", 190),
            new Apple("green", 90),
            new Apple("green", 170)
    );


    public List<Apple> filter(Predicate<Apple> predicate) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterGreenApples() {
        return filter(Apple::isGreenApple);
    }

    public List<Apple> filterHeavyApples() {
        return filter(Apple::isHeavyApple);
    }

    //considering about guava


}
