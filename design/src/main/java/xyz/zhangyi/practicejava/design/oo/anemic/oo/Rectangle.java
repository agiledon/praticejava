package xyz.zhangyi.practicejava.design.oo.anemic.oo;

public class Rectangle {
    // 没有访问width的需求时，就不暴露该字段
    private int width;
    // 没有访问length的需求时，就不暴露该字段
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int area() {
        return this.width * this.length;
    }

    public int perimeter() {
        return (this.width + this.length) * 2;
    }
}
