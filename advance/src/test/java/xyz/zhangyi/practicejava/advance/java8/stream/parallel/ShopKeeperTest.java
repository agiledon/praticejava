package xyz.zhangyi.practicejava.advance.java8.stream.parallel;

import org.junit.Test;

import java.util.List;

public class ShopKeeperTest {
    private ShopKeeper keeper = new ShopKeeper();

    @Test
    public void should_find_price_sequence() {
        performance(keeper::findPrices);
    }

    @Test
    public void should_find_price_parallel() {
        performance(keeper::findPricesQuickly);
    }

    private void performance(GetPrice command) {
        long start = System.nanoTime();
        System.out.println(command.execute("iphone6"));
        long duration = (System.nanoTime() - start) /1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    private interface GetPrice {
        List<String> execute(String product);
    }
}