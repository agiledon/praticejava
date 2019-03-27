package xyz.zhangyi.practicejava.advance.java8.defaultmethod;

public interface ExternalResourceEnricher {
    default ExternalResource enrich(ExternalResource resource, String info)
    {
        return resource.withInfo(info);
    }
}
