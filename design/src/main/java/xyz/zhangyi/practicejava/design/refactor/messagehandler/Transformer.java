package xyz.zhangyi.practicejava.design.refactor.messagehandler;

public class Transformer {
    public Transformer() {
    }

    public Transformer forCustomer(String name) {
        return this;
    }

    public MessageWriter transform() {
        return null;
    }
}
