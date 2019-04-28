package xyz.zhangyi.practicejava.design.oo.anemic;

public class Painter {
    public void draw(Rectangle rectangle) {
        // ...

        // 产生了和Geometric::area()方法一样的代码
        int area = rectangle.getWidth() * rectangle.getLength();

        //...
    }
}