import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("Fruits: " + fruits);
        System.out.println("First fruit: " + fruits.get(0));

        fruits.set(1, "Grapes");
        fruits.remove("Mango");

        System.out.println("Size: " + fruits.size());
        System.out.println("Contains Apple: " + fruits.contains("Apple"));
        System.out.println("Final ArrayList: " + fruits);
    }
}