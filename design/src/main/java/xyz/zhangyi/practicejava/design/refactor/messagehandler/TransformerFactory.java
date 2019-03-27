package xyz.zhangyi.practicejava.design.refactor.messagehandler;

public class TransformerFactory {
    public TransformerFactory() {
    }

    public Transformer transformerFor(MessageReader messageReader, MessageType messageType) {
        return new Transformer();
    }
}
