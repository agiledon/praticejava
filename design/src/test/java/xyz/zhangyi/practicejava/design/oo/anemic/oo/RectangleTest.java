package xyz.zhangyi.practicejava.design.oo.anemic.oo;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RectangleTest {
    @Test
    public void should_calculate_area() {
        Rectangle rectangle = new Rectangle(5, 10);
        assertThat(rectangle.area()).isEqualTo(50);
    }

}