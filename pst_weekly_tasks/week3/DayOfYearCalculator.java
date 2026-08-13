import java.time.LocalDate;
import java.util.Scanner;

public class DayOfYearCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.println("Day of the week: " + date.getDayOfWeek());
    }
}