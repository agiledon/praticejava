package xyz.zhangyi.practicejava.advance.cocurrency.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSample {
    public void execute() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask task = new MyTask(i);
            executor.execute(task);
            System.out.println("Thread count in the pool: " + executor.getPoolSize());
            System.out.println("Awaiting task count in the queue: " + executor.getQueue().size());
            System.out.println("Completed task count: " + executor.getCompletedTaskCount());
        }

        executor.shutdown();
    }
}
