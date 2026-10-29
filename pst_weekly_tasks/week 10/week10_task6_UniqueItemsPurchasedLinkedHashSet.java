import java.util.*;

public class week10_task6_UniqueItemsPurchasedLinkedHashSet {
    public static void main(String[] args) {
        List<String> purchases = Arrays.asList("Milk", "Bread", "Milk", "Eggs", "Bread", "Butter");
        Set<String> uniquePurchases = new LinkedHashSet<>(purchases);

        System.out.println("Original Purchases: " + purchases);
        System.out.println("Unique Items (Order Preserved): " + uniquePurchases);
    }
}
