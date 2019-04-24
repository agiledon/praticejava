package xyz.zhangyi.practicejava.framework.mybatis.service;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Exception ex) {
        super(ex);
    }
}
