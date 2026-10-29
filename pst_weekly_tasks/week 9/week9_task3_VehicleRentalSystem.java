import java.util.Scanner;
import java.util.Locale;

public class week9_task3_VehicleRentalSystem {
    static class Vehicle {
        protected String vehicleNumber;
        protected double rentPerDay;

        public Vehicle(String vehicleNumber, double rentPerDay) {
            this.vehicleNumber = vehicleNumber;
            this.rentPerDay = rentPerDay;
        }

        public double calculateRent(int days) {
            return rentPerDay * days;
        }

        public String getVehicleNumber() {
            return vehicleNumber;
        }
    }

    static class Car extends Vehicle {
        public Car(String vehicleNumber, double rentPerDay) {
            super(vehicleNumber, rentPerDay);
        }

        @Override
        public double calculateRent(int days) {
            return rentPerDay * days;
        }
    }

    static class Bike extends Vehicle {
        public Bike(String vehicleNumber, double rentPerDay) {
            super(vehicleNumber, rentPerDay);
        }

        @Override
        public double calculateRent(int days) {
            return rentPerDay * days * 0.90;
        }
    }

    static class Truck extends Vehicle {
        public Truck(String vehicleNumber, double rentPerDay) {
            super(vehicleNumber, rentPerDay);
        }

        @Override
        public double calculateRent(int days) {
            return rentPerDay * days * 1.20;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int vehicleType = sc.nextInt();
            String vehicleNumber = sc.next();
            double rentPerDay = sc.nextDouble();
            int days = sc.nextInt();

            Vehicle vehicle;
            if (vehicleType == 1) {
                vehicle = new Car(vehicleNumber, rentPerDay);
            } else if (vehicleType == 2) {
                vehicle = new Bike(vehicleNumber, rentPerDay);
            } else {
                vehicle = new Truck(vehicleNumber, rentPerDay);
            }

            double totalRent = vehicle.calculateRent(days);
            System.out.printf(Locale.US, "%s %.2f%n", vehicle.getVehicleNumber(), totalRent);
        }
        sc.close();
    }
}
