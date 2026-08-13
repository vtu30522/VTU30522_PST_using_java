import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HeightSorting {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> heights = new ArrayList<>();

        names.add("Alice");
        heights.add(165);

        names.add("Bob");
        heights.add(180);

        names.add("Charlie");
        heights.add(170);

        names.add("David");
        heights.add(175);

        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            index.add(i);
        }

        // Sort indexes based on height in descending order
        Collections.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return heights.get(b) - heights.get(a);
            }
        });

        System.out.println("People sorted by height:");

        for (int i : index) {
            System.out.println(names.get(i) + " - " + heights.get(i) + " cm");
        }
    }
}