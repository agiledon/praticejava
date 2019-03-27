package xyz.zhangyi.practicejava.design.decuplication;

import java.util.ArrayList;
import java.util.List;

public class People {
    private List<Person> persons = new ArrayList<Person>();

    public void addPerson(String name, int age, Gender gender) {
        Person person = new Person(name, age, gender);
        persons.add(person);
    }

    public List<Person> findByName(String name) {
        List<Person> result = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                result.add(person);
            }
        }
        return result;
    }
}
