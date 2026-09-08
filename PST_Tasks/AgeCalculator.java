import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Birth Year: ");
        int year = sc.nextInt();

        System.out.print("Enter Birth Month: ");
        int month = sc.nextInt();

        System.out.print("Enter Birth Day: ");
        int day = sc.nextInt();

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);

        System.out.println("Age: " +
                age.getYears() + " Years, " +
                age.getMonths() + " Months, " +
                age.getDays() + " Days");

        sc.close();
    }
}