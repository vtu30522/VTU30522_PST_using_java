package ClassRoom_Tasks;

import java.util.*;
import java.util.stream.*;

public class ClassRoom_Task6_SalaryAscending {

    static class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        static List<Employee> sampleData() {
            return Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 35000),
                new Employee("Charlie", 45000),
                new Employee("David", 30000),
                new Employee("Eve", 60000)
            );
        }

        @Override
        public String toString() {
            return name + " " + salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Employee.sampleData();

        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.salary))
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }
}