package xyz.zhangyi.practicejava.framework.mockito;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RosterTest {
    private List<String> mockResult;

    @Before
    public void setUp() {
        mockResult = new ArrayList<>();
        mockResult.add("zhangyi");
        mockResult.add("bruce");
    }

    @Test
    public void should_parse_to_employee_list_from_roster_file() {
        //given
        Roster roster = new Roster();

        String fileName = "roster.txt";
        TextFileReader mockReader = mock(TextFileReader.class);
        when(mockReader.read(fileName)).thenReturn(mockResult);

        roster.setReader(mockReader);

        //when
        List<Employee> employees = roster.fetchRoster(fileName);

        //then
        verify(mockReader, times(1)).read(fileName);
        Assertions.assertThat(employees).hasSize(2);
        assertThat(employees.get(0).getName()).isEqualTo("zhangyi");
    }

    private class MockTextFileReader extends TextFileReader {
        @Override
        public List<String> read(String fileName) {
            return mockResult;
        }
    }
}