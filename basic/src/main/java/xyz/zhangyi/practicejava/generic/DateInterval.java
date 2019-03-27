package xyz.zhangyi.practicejava.generic;

import java.util.Date;

public class DateInterval extends Pair<Date, Date> {
    public DateInterval(Date first, Date second) {
        super(first, second);
    }

    public void setSecond(Date second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }
}
