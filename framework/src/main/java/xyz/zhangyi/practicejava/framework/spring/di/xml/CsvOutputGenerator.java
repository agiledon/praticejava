package xyz.zhangyi.practicejava.framework.spring.di.xml;

public class CsvOutputGenerator implements OutputGenerator {
    @Override
    public String generateOutput() {
        return "csv";
    }
}
