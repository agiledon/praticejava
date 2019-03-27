package xyz.zhangyi.practicejava.design.cleancode.decuplication;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleTest {
    @Test
    public void should_find_person_by_name() {
        People people = new People();
        people.addPerson("zhangyi", 40, Gender.Male);

        assertThat(people.findByName("zhangyi")).isNotNull().hasSize(1);
    }
}