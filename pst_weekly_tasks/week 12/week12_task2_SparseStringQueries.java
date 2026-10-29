import java.util.*;

public class week12_task2_SparseStringQueries {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        Map<String, Integer> counts = new HashMap<>();
        for (String s : stringList) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (String q : queries) {
            result.add(counts.getOrDefault(q, 0));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");

        System.out.println(matchingStrings(stringList, queries));
    }
}
