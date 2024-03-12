import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top10Words {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\P{IsAlphabetic}+");
                for (String word : words) {
                    word = word.toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> sortedWordCount = new ArrayList<>(wordCount.entrySet());
        sortedWordCount.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        sortedWordCount.remove(0);
        for (int i = 0; i < Math.min(10, sortedWordCount.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWordCount.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
