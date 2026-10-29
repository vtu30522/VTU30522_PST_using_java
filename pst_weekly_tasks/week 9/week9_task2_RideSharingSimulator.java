import java.util.Scanner;

public class week9_task2_RideSharingSimulator {
    static abstract class Vehicle {
        abstract double calculateFare(double distance);
    }

    static class Bike extends Vehicle {
        double calculateFare(double distance) {
            return distance * 5;
        }
    }

    static class Auto extends Vehicle {
        double calculateFare(double distance) {
            return distance * 12;
        }
    }

    static class Cab extends Vehicle {
        double calculateFare(double distance) {
            return distance * 12;
        }
    }

    static class InvalidBookingException extends Exception {
        InvalidBookingException(String message) {
            super(message);
        }
    }

    static Vehicle createVehicle(String type) throws InvalidBookingException {
        switch (type) {
            case "Bike":
                return new Bike();
            case "Auto":
                return new Auto();
            case "Cab":
                return new Cab();
            default:
                throw new InvalidBookingException("Invalid ride type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            if (parts.length < 2) continue;
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);
            try {
                Vehicle vehicle = createVehicle(type);
                System.out.println((int) vehicle.calculateFare(distance));
            } catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
