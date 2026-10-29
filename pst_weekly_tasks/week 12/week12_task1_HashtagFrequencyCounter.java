import java.util.*;

public class week12_task1_HashtagFrequencyCounter {
    public static void main(String[] args) {
        List<String> hashtags = Arrays.asList("#java", "#coding", "#java", "#tech", "#coding", "#java");

        Map<String, Integer> freqMap = new HashMap<>();
        for (String tag : hashtags) {
            freqMap.put(tag, freqMap.getOrDefault(tag, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue().compareTo(a.getValue());
            }
            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
