package app.parser_h11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAnalyzer {
    public Map<String, Integer> analyzeText(String content) {
        String normalizedText = content.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        String[] words = normalizedText.split("\\s+");

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequency;
    }

    public List<Map.Entry<String, Integer>> getTopWords(Map<String, Integer> wordFrequency, int limit) {
        return wordFrequency.entrySet().stream()
                .filter(entry -> entry.getKey().length() > 2)
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(limit)
                .toList();
    }

    public long countUniqueWords(Map<String, Integer> wordFrequency) {
        return wordFrequency.keySet().size();
    }
}
