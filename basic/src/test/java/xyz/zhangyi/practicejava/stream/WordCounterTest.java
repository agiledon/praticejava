package xyz.zhangyi.practicejava.stream;

import org.junit.Before;
import org.junit.Test;
import xyz.zhangyi.practicejava.stream.WordCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCounterTest {

    private WordCounter wordCounter;

    @Before
    public void setUp() throws Exception {
        wordCounter = new WordCounter();
    }

    @Test
    public void should_count_words() {
        List<String> lines = new ArrayList<>();
        lines.add("I love java");
        lines.add("I love programming");
        lines.add("I am developer");
        lines.add("I love java");
        lines.add("I love java");
        Map<String, Integer> countResult = wordCounter.count(lines);
        assertThat(countResult.get("I")).isEqualTo(5);
        assertThat(countResult.get("java")).isEqualTo(3);
        assertThat(countResult.get("developer")).isEqualTo(1);
    }

}