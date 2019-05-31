package xyz.zhangyi.practicejava.framework.spring.di.componentscan;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("simple")
public class SimpleMovieFinder implements MovieFinder {
    @Override
    public List<Movie> findAll() {
        return new ArrayList<>();
    }
}
