package xyz.zhangyi.practicejava.framework.mybatis.service;

public class ApplicationException extends RuntimeException {
    public ApplicationException(Exception ex) {
        super(ex);
    }
}
