import java.util.*;
import java.util.stream.Collectors;

public class SalaryTransformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> salaries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            salaries.add(sc.nextInt());
        }

        List<Integer> updated = salaries.stream()
                                        .map(salary -> (int)(salary * 1.1))
                                        .collect(Collectors.toList());

        updated.forEach(salary -> System.out.print(salary + " "));

        sc.close();
    }
}