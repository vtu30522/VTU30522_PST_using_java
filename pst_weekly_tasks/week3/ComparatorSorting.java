import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorSorting {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(50);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(30);

        // Sort in ascending order using Comparator
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        System.out.println("Ascending order: " + numbers);

        // Sort in descending order using Comparator
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        System.out.println("Descending order: " + numbers);
    }
}