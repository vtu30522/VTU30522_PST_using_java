import java.util.*;

public class week10_task10_PhoneContactDirectory {
    private Map<String, String> contacts = new HashMap<>();

    public void addOrUpdateContact(String name, String phone) {
        contacts.put(name, phone);
        System.out.println("Saved: " + name + " -> " + phone);
    }

    public String searchContact(String name) {
        return contacts.getOrDefault(name, "Contact not found");
    }

    public static void main(String[] args) {
        week10_task10_PhoneContactDirectory directory = new week10_task10_PhoneContactDirectory();
        directory.addOrUpdateContact("Alice", "9876543210");
        directory.addOrUpdateContact("Bob", "9123456789");

        System.out.println("Search Alice: " + directory.searchContact("Alice"));

        // Update Bob's number
        directory.addOrUpdateContact("Bob", "9998887776");
        System.out.println("Search Bob: " + directory.searchContact("Bob"));
    }
}
