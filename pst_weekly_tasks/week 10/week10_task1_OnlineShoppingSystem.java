import java.util.*;

public class week10_task1_OnlineShoppingSystem {
    static class Product {
        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    static class Order implements Comparable<Order> {
        int orderId;
        int priority; // 1 = highest

        Order(int orderId, int priority) {
            this.orderId = orderId;
            this.priority = priority;
        }

        @Override
        public int compareTo(Order o) {
            return Integer.compare(this.priority, o.priority);
        }
    }

    public static void main(String[] args) {
        Map<Integer, Product> productCatalog = new HashMap<>();
        productCatalog.put(101, new Product(101, "Laptop", 75000));
        productCatalog.put(102, new Product(102, "Phone", 25000));

        PriorityQueue<Order> orderQueue = new PriorityQueue<>();
        orderQueue.add(new Order(1001, 2));
        orderQueue.add(new Order(1002, 1)); // High priority

        System.out.println("Product 101: " + productCatalog.get(101).name);

        while (!orderQueue.isEmpty()) {
            Order o = orderQueue.poll();
            System.out.println("Processing Order ID: " + o.orderId + " (Priority: " + o.priority + ")");
        }
    }
}
