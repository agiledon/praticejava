package xyz.zhangyi.practicejava.design.refactor.messagehandler;

public class ScenarioContext {
    private String responseText;
    private MessageReader responseMessage;
    private MessageWriter expectedMessage;
    private MessageReader requestMessage;
    private String customerVersion;

    public ScenarioContext() {
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public void setResponseMessage(MessageReader responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean hasExpectedMessage() {
        return false;
    }

    public MessageWriter getExpectedMessage() {
        return this.expectedMessage;
    }

    public MessageReader getRequestMessage() {
        return this.requestMessage;
    }

    public String getCustomerVersion() {
        return this.customerVersion;
    }
}
