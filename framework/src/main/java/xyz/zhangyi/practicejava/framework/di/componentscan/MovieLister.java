package xyz.zhangyi.practicejava.framework.di.componentscan;/*                                                                      *\
**                                                                      **
**      __  __ _________ _____          ©Mort BI                        **
**     |  \/  / () | () |_   _|         (c) 2015                        **
**     |_|\/|_\____|_|\_\ |_|           http://www.bigeyedata.com       **
**                                                                      **
\*                                                                      */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieLister {
    final private MovieFinder movieFinder;

    @Autowired
    public MovieLister(@Qualifier("simple") MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public List<Movie> moviesDirectedBy(String director) {
        List<Movie> movies = movieFinder.findAll();
        return movies.stream()
                .filter(m -> m.getDirector().equals(director))
                .collect(Collectors.toList());
    }
}
