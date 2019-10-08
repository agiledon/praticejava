package xyz.zhangyi.practicejava.design.oo.interfaces;

import java.util.Comparator;

public final class EmployeeComparator {
    private EmployeeComparator() {
    }

    public static Comparator<Employee> byAge() {
        return Comparator.comparingInt(Employee::getAge);
    }
}
