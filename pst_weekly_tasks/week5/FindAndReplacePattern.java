import java.util.*;

public class FindAndReplacePattern {

    public static boolean matchesPattern(String word, String pattern) {

        // Mapping from word -> pattern
        Map<Character, Character> map1 = new HashMap<>();

        // Mapping from pattern -> word
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {

            char w = word.charAt(i);
            char p = pattern.charAt(i);

            // Check word -> pattern mapping
            if (map1.containsKey(w) && map1.get(w) != p) {
                return false;
            }

            // Check pattern -> word mapping
            if (map2.containsKey(p) && map2.get(p) != w) {
                return false;
            }

            map1.put(w, p);
            map2.put(p, w);
        }

        return true;
    }

    public static List<String> findAndReplacePattern(
            String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (matchesPattern(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        String pattern = sc.next();

        List<String> result =
                findAndReplacePattern(words, pattern);

        System.out.println(result);

        sc.close();
    }
}