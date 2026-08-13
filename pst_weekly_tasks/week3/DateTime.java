import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class DateTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date);
        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dateTime);
        LocalDate specificDate = LocalDate.of(2026, 8, 12);
        System.out.println("Specific Date: " + specificDate);
        System.out.println("Year: " + date.getYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Day: " + date.getDayOfMonth());
        LocalDate futureDate = date.plusDays(10);
        System.out.println("After 10 days: " + futureDate);
        LocalDate previousDate = date.minusDays(10);
        System.out.println("10 days ago: " + previousDate);
    }
}