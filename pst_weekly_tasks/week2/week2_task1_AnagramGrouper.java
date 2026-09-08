import java.util.*;

public class AnagramGrouper {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        List<List<String>> result = groupAnagrams(strs);

        for (List<String> group : result) {
            for (String word : group) {
                System.out.print(word + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}