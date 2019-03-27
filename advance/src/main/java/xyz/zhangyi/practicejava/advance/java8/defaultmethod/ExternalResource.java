package xyz.zhangyi.practicejava.advance.java8.defaultmethod;

public class ExternalResource {
    private String name;
    private String info;

    public ExternalResource(String name) {
        this.name = name;
    }

    public ExternalResource withInfo(String info) {
        this.info = info;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
