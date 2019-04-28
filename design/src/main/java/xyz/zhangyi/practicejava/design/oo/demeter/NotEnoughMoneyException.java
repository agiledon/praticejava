package xyz.zhangyi.practicejava.design.oo.demeter;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        super("Money is not enough");
    }

    public NotEnoughMoneyException(String message, Throwable cause) {
        super(message, cause);
    }
}
