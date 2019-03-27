package xyz.zhangyi.practicejava.framework.spring.di.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieLister {
    final private MovieFinder movieFinder;

    @Autowired
    public MovieLister(@Qualifier("default") MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public List<Movie> moviesDirectedBy(String director) {
        List<Movie> movies = movieFinder.findAll();
        return movies.stream()
                .filter(m -> m.getDirector().equals(director))
                .collect(Collectors.toList());
    }
}
