package xyz.zhangyi.practicejava.design.refactor.messagehandler.checker;

import xyz.zhangyi.practicejava.design.refactor.messagehandler.MessageReader;

public class SO05MessageChecker extends MessageChecker {
    public SO05MessageChecker(MessageReader expectedMessage, String actualMessage) {
        super(expectedMessage, actualMessage);
    }

    @Override
    public void checkResponse() {

    }
}
