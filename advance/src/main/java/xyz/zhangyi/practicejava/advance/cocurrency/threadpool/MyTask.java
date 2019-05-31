package xyz.zhangyi.practicejava.advance.cocurrency.threadpool;/*                                                                      *\
**                                                                      **
**      __  __ _________ _____          ©Mort BI                        **
**     |  \/  / () | () |_   _|         (c) 2015                        **
**     |_|\/|_\____|_|\_\ |_|           http://www.bigeyedata.com       **
**                                                                      **
\*                                                                      */

public class MyTask implements Runnable {
    private int taskNumber;

    public MyTask(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        System.out.println("***MyTask: Executing task with number:" + taskNumber);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("***MyTask:Task with number %d is finished", taskNumber));
    }
}
