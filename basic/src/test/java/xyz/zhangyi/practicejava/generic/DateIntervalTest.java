package xyz.zhangyi.practicejava.generic;

import org.junit.Test;

import java.util.Date;

public class DateIntervalTest {
    @Test
    public void should_be_error() {
        Date d1 = new Date(2019, 1, 12);
        Date d2 = new Date(2019, 5, 12);
        DateInterval interval = new DateInterval(d1, d2);
        Pair<Date, Date> pair = interval;
        Date aDate = new Date(2019, 6, 12);
        pair.setSecond(aDate);
    }
}