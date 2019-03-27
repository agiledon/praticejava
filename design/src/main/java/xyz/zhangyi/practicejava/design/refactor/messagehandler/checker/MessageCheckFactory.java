package xyz.zhangyi.practicejava.design.refactor.messagehandler.checker;

import xyz.zhangyi.practicejava.design.refactor.messagehandler.MessageReader;
import xyz.zhangyi.practicejava.design.refactor.messagehandler.MessageType;

public class MessageCheckFactory {
    public MessageChecker checkerFor(MessageType messageType, MessageReader expectedMessage, String actualMessage) {
        switch (messageType) {
            case SO05:
                return new SO05MessageChecker(expectedMessage, actualMessage);
            case SO07:
                return new SO07MessageChecker(expectedMessage, actualMessage);
            case SO08:
                return new SO08MessageChecker(expectedMessage, actualMessage);
            default:
                return new DefaultMessageChecker(expectedMessage, actualMessage);
        }
    }
}
