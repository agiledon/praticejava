package xyz.zhangyi.practicejava.design.cleancode.exception.validator;/*                                                                      *\
**                                                                      **
**      __  __ _________ _____          ©Mort BI                        **
**     |  \/  / () | () |_   _|         (c) 2015                        **
**     |_|\/|_\____|_|\_\ |_|           http://www.bigeyedata.com       **
**                                                                      **
\*                                                                      */

public class InvalidPackageException extends RuntimeException {
    public InvalidPackageException(String message) {
        super(message);
    }
}
