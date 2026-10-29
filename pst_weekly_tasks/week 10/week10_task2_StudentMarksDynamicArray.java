import java.util.*;

public class week10_task2_StudentMarksDynamicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> marks = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                marks.add(sc.nextInt());
            }
        } else {
            marks.addAll(Arrays.asList(85, 90, 78, 92, 88));
        }

        System.out.println("Stored Student Marks: " + marks);
        sc.close();
    }
}
