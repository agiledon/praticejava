package xyz.zhangyi.practicejava.design.bank;

public class Money {
    private long faceValue;
    private Currency currency;

    public Money(long faceValue, Currency currency) {

        this.faceValue = faceValue;
        this.currency = currency;
    }
}
