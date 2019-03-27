package xyz.zhangyi.practicejava.design.refactor.messagehandler.checker;


import xyz.zhangyi.practicejava.design.refactor.messagehandler.MessageReader;

public abstract class MessageChecker {
    protected final MessageReader expectedMessage;
    protected final String actualMessage;

    public MessageChecker(MessageReader expectedMessage, String actualMessage) {
        this.expectedMessage = expectedMessage;
        this.actualMessage = actualMessage;
    }

    public abstract void checkResponse();
}
