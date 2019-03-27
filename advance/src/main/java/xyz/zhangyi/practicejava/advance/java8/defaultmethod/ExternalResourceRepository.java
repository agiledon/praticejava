package xyz.zhangyi.practicejava.advance.java8.defaultmethod;

public interface ExternalResourceRepository {
    default ExternalResource fetch() {
        return null;
    }
}
