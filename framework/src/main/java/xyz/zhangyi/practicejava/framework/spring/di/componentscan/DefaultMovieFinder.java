package xyz.zhangyi.practicejava.framework.spring.di.componentscan;/*                                                                      *\
**                                                                      **
**      __  __ _________ _____          ©Mort BI                        **
**     |  \/  / () | () |_   _|         (c) 2015                        **
**     |_|\/|_\____|_|\_\ |_|           http://www.bigeyedata.com       **
**                                                                      **
\*                                                                      */

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("default")
public class DefaultMovieFinder implements MovieFinder {
    @Override
    public List<Movie> findAll() {
        return Arrays.asList(
                new Movie("qiujudaguansi", "zhang yimou"),
                new Movie("bawangbieji", "chen kaige")
        );
    }
}
