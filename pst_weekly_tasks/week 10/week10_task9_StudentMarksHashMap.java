import java.util.*;

public class week10_task9_StudentMarksHashMap {
    public static void main(String[] args) {
        Map<String, Integer> studentMarksMap = new HashMap<>();

        studentMarksMap.put("101", 88);
        studentMarksMap.put("102", 95);
        studentMarksMap.put("103", 79);

        Scanner sc = new Scanner(System.in);
        String rollNo = sc.hasNext() ? sc.next() : "102";

        if (studentMarksMap.containsKey(rollNo)) {
            System.out.println("Roll Number " + rollNo + " Marks: " + studentMarksMap.get(rollNo));
        } else {
            System.out.println("Student record not found for Roll Number: " + rollNo);
        }
        sc.close();
    }
}
