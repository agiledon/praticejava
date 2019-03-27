package xyz.zhangyi.practicejava.framework.di.componentscan;/*                                                                      *\
**                                                                      **
**      __  __ _________ _____          ©Mort BI                        **
**     |  \/  / () | () |_   _|         (c) 2015                        **
**     |_|\/|_\____|_|\_\ |_|           http://www.bigeyedata.com       **
**                                                                      **
\*                                                                      */

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
