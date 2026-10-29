import java.util.*;

public class week10_task4_StudentMarksArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> marks = new ArrayList<>();

        if (sc.hasNextDouble()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                marks.add(sc.nextDouble());
            }
        } else {
            marks.addAll(Arrays.asList(85.5, 92.0, 78.0, 88.5, 95.0));
        }

        System.out.println("Marks: " + marks);

        double maxMark = Collections.max(marks);
        double sum = 0;
        for (double m : marks) sum += m;
        double avg = sum / marks.size();

        System.out.println("Highest Mark: " + maxMark);
        System.out.printf(Locale.US, "Average Mark: %.2f%n", avg);
        sc.close();
    }
}
