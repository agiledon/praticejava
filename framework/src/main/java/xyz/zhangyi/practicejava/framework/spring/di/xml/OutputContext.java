package xyz.zhangyi.practicejava.framework.spring.di.xml;/*                                                                      *\
**                                                                      **
**      __  __ _________ _____          ©Mort BI                        **
**     |  \/  / () | () |_   _|         (c) 2015                        **
**     |_|\/|_\____|_|\_\ |_|           http://www.bigeyedata.com       **
**                                                                      **
\*                                                                      */

public class OutputContext {
    private OutputGenerator outputGenerator;

    public void setOutputGenerator(OutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }

    public String generate() {
        return this.outputGenerator.generateOutput();
    }
}
