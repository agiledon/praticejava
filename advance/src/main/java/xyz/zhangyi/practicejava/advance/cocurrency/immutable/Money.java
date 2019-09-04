package xyz.zhangyi.practicejava.advance.cocurrency.immutable;

public final class Money {
    private final int faceValue;
    private final Currency currency;

    public Money() {
        this(0, Currency.RMB);
    }

    public Money(int faceValue) {
        this(faceValue, Currency.RMB);
    }

    public Money(int faceValue, Currency currency) {
        this.faceValue = faceValue;
        this.currency = currency;
    }

    public Money add(Money money) {
        if (this.currency != money.getCurrency()) {
            throw new CurrencyNotMatchedException();
        }

        return new Money(this.faceValue + money.getFaceValue(), this.currency);
    }

    public Money substract(Money money) {
        if (this.currency != money.getCurrency()) {
            throw new CurrencyNotMatchedException();
        }
        if (this.getFaceValue() < money.getFaceValue()) {
            throw new NotEnoughMoneyException();
        }

        return new Money(this.faceValue - money.getFaceValue(), this.currency);

    }

    public int getFaceValue() {
        return faceValue;
    }

    public Currency getCurrency() {
        return currency;
    }
}
