import java.util.*;

class EmployeeData {
    String name;
    int salary;

    EmployeeData(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + salary;
    }
}

public class Employee {
    public static void main(String[] args) {

        ArrayList<EmployeeData> employees = new ArrayList<>();

        employees.add(new EmployeeData("John", 50000));
        employees.add(new EmployeeData("David", 30000));
        employees.add(new EmployeeData("Alice", 40000));
        employees.add(new EmployeeData("Bob", 25000));

        Collections.sort(employees, new Comparator<EmployeeData>() {
            public int compare(EmployeeData e1, EmployeeData e2) {
                return Integer.compare(e1.salary, e2.salary);
            }
        });

        for (EmployeeData e : employees) {
            System.out.println(e);
        }
    }
}