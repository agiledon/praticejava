package xyz.zhangyi.practicejava.design.patterns.decorator;

import java.time.LocalDate;

public class LoggingDecorator extends User {
    private User user;

    public LoggingDecorator(User user) {
        this.user = user;
    }

    @Override
    public void login() {
        System.out.println(LocalDate.now());
        this.user.login();
    }
}
