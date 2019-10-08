package xyz.zhangyi.practicejava.design.oo.interfaces;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static xyz.zhangyi.practicejava.design.oo.interfaces.EmployeeComparator.byAge;

public class EmployeeTest {
    @Test
    public void should_sort_employees_by_age_with_ascending_order() {
        Employee zhangyi = new Employee("001", "zhangyi", 43);
        Employee zhoutianlu = new Employee("002", "zhoutianlu", 33);
        Employee hetian = new Employee("003", "hetian", 23);

        List<Employee> employees = new ArrayList<>();
        employees.add(zhangyi);
        employees.add(zhoutianlu);
        employees.add(hetian);
        printEmployees(employees);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                if (employee.getAge() < t1.getAge()) return -1;
                if (employee.getAge() == t1.getAge()) return 0;
                return 1;
            }
        });
        printEmployees(employees);

        Collections.sort(employees, byAge());
        printEmployees(employees);

        Collections.sort(employees);
        printEmployees(employees);

    }

    private void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("***********************");
    }
}