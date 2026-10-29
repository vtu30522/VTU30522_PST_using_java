import java.util.*;

public class week11_task4_SecondLowestGradeStudents {
    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < n; i++) {
                String name = sc.nextLine().trim();
                double grade = Double.parseDouble(sc.nextLine().trim());
                students.add(new Student(name, grade));
            }
        } else {
            students.add(new Student("Harry", 37.21));
            students.add(new Student("Berry", 37.21));
            students.add(new Student("Tina", 37.2));
            students.add(new Student("Akriti", 41.0));
            students.add(new Student("Harsh", 39.0));
        }

        TreeSet<Double> uniqueGrades = new TreeSet<>();
        for (Student s : students) uniqueGrades.add(s.grade);

        if (uniqueGrades.size() > 1) {
            Iterator<Double> it = uniqueGrades.iterator();
            it.next(); // lowest
            double secondLowest = it.next();

            List<String> names = new ArrayList<>();
            for (Student s : students) {
                if (s.grade == secondLowest) {
                    names.add(s.name);
                }
            }

            Collections.sort(names);
            for (String name : names) {
                System.out.println(name);
            }
        }
        sc.close();
    }
}
