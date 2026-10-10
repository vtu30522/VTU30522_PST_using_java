import java.util.*;

public class Syllabus_Task7_HashtagFrequency  {
    public static void main(String[] args) {

        String[] hashtags = {"java", "python", "java", "ai", "python"};

        HashMap<String, Integer> map = new HashMap<>();

        for (String tag : hashtags) {
            map.put(tag, map.getOrDefault(tag, 0) + 1);
        }

        System.out.println("java " + map.get("java"));
        System.out.println("python " + map.get("python"));
        System.out.println("ai " + map.get("ai"));
    }
}