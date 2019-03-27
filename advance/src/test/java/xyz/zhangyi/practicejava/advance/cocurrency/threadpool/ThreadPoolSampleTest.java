package xyz.zhangyi.practicejava.advance.cocurrency.threadpool;

import org.junit.Test;

public class ThreadPoolSampleTest {

    @Test
    public void should_execute_multi_tasks_in_thread_pool() {
        ThreadPoolSample threadPoolSample = new ThreadPoolSample();
        threadPoolSample.execute();
    }
}