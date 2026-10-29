import java.util.*;

public class week12_task10_ProductInventoryAnalysis {
    static class Product {
        int id;
        String name;
        int stock;
        double price;

        Product(int id, String name, int stock, double price) {
            this.id = id;
            this.name = name;
            this.stock = stock;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Stock: " + stock + ", Price: $" + price;
        }
    }

    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.id, p);
    }

    public void processSale(int id, int quantity) {
        Product p = inventory.get(id);
        if (p != null) {
            p.stock = Math.max(0, p.stock - quantity);
            System.out.println("Sale processed for " + p.name + ". Remaining stock: " + p.stock);
        }
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStock = new ArrayList<>();
        for (Product p : inventory.values()) {
            if (p.stock < threshold) {
                lowStock.add(p);
            }
        }
        lowStock.sort(Comparator.comparingInt(p -> p.stock));
        return lowStock;
    }

    public static void main(String[] args) {
        week12_task10_ProductInventoryAnalysis store = new week12_task10_ProductInventoryAnalysis();
        store.addProduct(new Product(1, "Rice", 50, 40.0));
        store.addProduct(new Product(2, "Wheat", 10, 30.0));
        store.addProduct(new Product(3, "Sugar", 5, 45.0));

        store.processSale(2, 6);

        System.out.println("\nLow Stock Products (Threshold = 10):");
        for (Product p : store.getLowStockProducts(10)) {
            System.out.println(p);
        }
    }
}
