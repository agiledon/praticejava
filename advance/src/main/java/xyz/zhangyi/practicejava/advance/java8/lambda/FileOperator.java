package xyz.zhangyi.practicejava.advance.java8.lambda;

import java.io.File;


/**
 * ::syntax means Java 8 method reference ("use this method as value")
 * or using labmda: file -> file.isHidden()
 */
public class FileOperator {
    public File[] filterHiddenFiles() {
        return new File(".").listFiles(File::isHidden);
    }
}
