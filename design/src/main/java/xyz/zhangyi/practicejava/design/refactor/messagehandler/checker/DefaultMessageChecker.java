package xyz.zhangyi.practicejava.design.refactor.messagehandler.checker;


import xyz.zhangyi.practicejava.design.refactor.messagehandler.MessageReader;

public class DefaultMessageChecker extends MessageChecker {
    public DefaultMessageChecker(MessageReader expectedMessage, String actualMessage) {
        super(expectedMessage, actualMessage);
    }

    @Override
    public void checkResponse() {

    }
}
