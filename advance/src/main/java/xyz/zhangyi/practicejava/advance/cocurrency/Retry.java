package xyz.zhangyi.practicejava.advance.cocurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public final class Retry {
    private static final int MAX_RETRY_TIMES = 5;
    private final AtomicInteger atomicTimes;

    public Retry() {
        atomicTimes = new AtomicInteger(MAX_RETRY_TIMES);
    }

    public Retry(int times) {
        atomicTimes = new AtomicInteger(times);
    }

    public void execute(Supplier<Boolean> supplier) {
        while (atomicTimes.getAndDecrement() > 0) {
            if (supplier.get()) {
                break;
            }
        }
    }
}
