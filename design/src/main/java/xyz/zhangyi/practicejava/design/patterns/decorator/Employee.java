package xyz.zhangyi.practicejava.design.patterns.decorator;

public class Employee extends User {
    @Override
    public void login() {
        super.login();
        System.out.println("employee login");
    }
}
