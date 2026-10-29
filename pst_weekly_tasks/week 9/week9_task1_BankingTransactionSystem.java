import java.util.Scanner;

public class week9_task1_BankingTransactionSystem {
    static class BankAccount {
        private int balance = 0;

        public void deposit(int amount) {
            balance += amount;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }

        public int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        BankAccount account = new BankAccount();

        for (int i = 0; i < n; i++) {
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            if (parts.length < 2) continue;
            int amount = Integer.parseInt(parts[1]);
            if (parts[0].equalsIgnoreCase("Deposit")) {
                account.deposit(amount);
            } else if (parts[0].equalsIgnoreCase("Withdraw")) {
                account.withdraw(amount);
            }
        }

        System.out.println(account.getBalance());
        sc.close();
    }
}
