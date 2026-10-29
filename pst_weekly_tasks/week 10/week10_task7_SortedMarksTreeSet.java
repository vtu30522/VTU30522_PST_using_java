import java.util.*;

public class week10_task7_SortedMarksTreeSet {
    public static void main(String[] args) {
        List<Integer> rawMarks = Arrays.asList(85, 70, 95, 70, 85, 60, 90);
        Set<Integer> sortedUniqueMarks = new TreeSet<>(rawMarks);

        System.out.println("Raw Marks: " + rawMarks);
        System.out.println("Unique Marks in Ascending Order: " + sortedUniqueMarks);
    }
}
