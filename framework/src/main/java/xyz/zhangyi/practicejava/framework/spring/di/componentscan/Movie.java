package xyz.zhangyi.practicejava.framework.spring.di.componentscan;/*                                                                      *\
**                                                                      **
**      __  __ _________ _____          ©Mort BI                        **
**     |  \/  / () | () |_   _|         (c) 2015                        **
**     |_|\/|_\____|_|\_\ |_|           http://www.bigeyedata.com       **
**                                                                      **
\*                                                                      */

public class Movie {
    private String name;
    private String director;

    public Movie(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return String.format("Movie name %s directed by %s", name, director);
    }
}
