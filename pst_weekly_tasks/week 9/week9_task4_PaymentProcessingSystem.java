import java.util.Scanner;
import java.util.Locale;

public class week9_task4_PaymentProcessingSystem {
    interface Payment {
        void pay(double amount);
        double getFeePercentage();
        String getPaymentName();
    }

    static class CreditCardPayment implements Payment {
        public void pay(double amount) {}
        public double getFeePercentage() { return 0.02; }
        public String getPaymentName() { return "CreditCard"; }
    }

    static class UPIPayment implements Payment {
        public void pay(double amount) {}
        public double getFeePercentage() { return 0.01; }
        public String getPaymentName() { return "UPI"; }
    }

    static class NetBankingPayment implements Payment {
        public void pay(double amount) {}
        public double getFeePercentage() { return 0.015; }
        public String getPaymentName() { return "NetBanking"; }
    }

    static abstract class PaymentProcessor {
        abstract double processPayment(Payment payment, double amount);
    }

    static class OnlinePaymentProcessor extends PaymentProcessor {
        @Override
        double processPayment(Payment payment, double amount) {
            payment.pay(amount);
            return amount * (1.0 + payment.getFeePercentage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {
            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;
            if (paymentType == 1) {
                payment = new CreditCardPayment();
            } else if (paymentType == 2) {
                payment = new UPIPayment();
            } else {
                payment = new NetBankingPayment();
            }

            double finalAmount = processor.processPayment(payment, amount);
            System.out.printf(Locale.US, "%s %.2f%n", payment.getPaymentName(), finalAmount);
        }
        sc.close();
    }
}
