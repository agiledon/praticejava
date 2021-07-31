package xyz.zhangyi.practicejava.advance.annotation;

import xyz.zhangyi.practicejava.annotation.MyGetter;

@MyGetter
public class TryToUseGetter {
    private String value;

    public TryToUseGetter(String value) {
        this.value = value;
    }
}
