package xyz.zhangyi.practicejava.design.oo.anemic;

public class Geometric {
    public int area(Rectangle rectangle) {
        return rectangle.getWidth() * rectangle.getLength();
    }

    public int perimeter(Rectangle rectangle) {
        return (rectangle.getWidth() + rectangle.getLength()) * 2;
    }
}
