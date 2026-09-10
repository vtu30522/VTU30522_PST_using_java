package ClassRoom_Tasks;

import java.util.*;
import java.util.stream.*;

public class ClassRoom_Task8_DepartmentAlphabetical {

    static class Employee {
        String name;
        double salary;
        String department;

        Employee(String name, double salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        static List<Employee> sampleData() {
            return Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 35000, "Finance"),
                new Employee("Charlie", 45000, "IT"),
                new Employee("David", 30000, "Finance"),
                new Employee("Eve", 60000, "Marketing")
            );
        }

        @Override
        public String toString() {
            return name + " " + salary + " " + department;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Employee.sampleData();

        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(e -> e.department))
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }
}S