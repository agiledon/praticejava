package xyz.zhangyi.practicejava.design.patterns.decorator;

public class SecurityDecorator extends User {
    private User user;

    public SecurityDecorator(User user) {
        this.user = user;
    }

    @Override
    public void login() {
        System.out.println("security");
        this.user.login();
    }
}
