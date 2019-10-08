package xyz.zhangyi.practicejava.design.oo.interfaces;

// 为了说明Comparable与Comparator的差别
// 严格意义上讲，Comparable才是接口的正确用法
// 引入Person和RegularEmployee是为了说明泛型的协变和逆变
public class Employee extends Person implements Comparable<Employee> {
    private String id;
    private String name;
    private int age;

    public Employee(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return id + ":" + name + ":" + age;
    }

    @Override
    public int compareTo(Employee employee) {
        if (this.age < employee.age) return -1;
        if (this.age == employee.age) return 0;
        return 1;
    }
}
