package xyz.zhangyi.practicejava.design.report.engine;

public class SimpleParameter implements Parameter{

    private Object[] value;

    @Override
    public String getName() {
        return null;
    }

    public void setValue(String[] value) {
        this.value = value;
    }
}
