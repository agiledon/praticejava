package xyz.zhangyi.practicejava.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {
    public Map<String, Integer> count(List<String> lines) {
        HashMap<String, Integer> map = new HashMap<>();

        List<String> words = lines.stream()
                .flatMap(l -> toList(l.split(" ")).stream())
                .collect(Collectors.toList());

        for (String word : words) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }

        return map;
    }

    public List<String> toList(String[] input) {
        List<String> result = new ArrayList<>();
        for (String str : input) {
            result.add(str);
        }
        return result;
    }
}
