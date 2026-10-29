import java.util.*;

public class week10_task8_CommonSubjectsRetainAll {
    public static void main(String[] args) {
        Set<String> student1Subjects = new HashSet<>(Arrays.asList("Math", "Physics", "Chemistry", "English"));
        Set<String> student2Subjects = new HashSet<>(Arrays.asList("Biology", "Chemistry", "Physics", "Computer"));

        Set<String> commonSubjects = new HashSet<>(student1Subjects);
        commonSubjects.retainAll(student2Subjects);

        System.out.println("Student 1 Subjects: " + student1Subjects);
        System.out.println("Student 2 Subjects: " + student2Subjects);
        System.out.println("Common Subjects: " + commonSubjects);
    }
}
