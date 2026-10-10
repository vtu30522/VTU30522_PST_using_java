class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double divide(int a, int b) {
        return (double) a / b;
    }
}

public class Syllabus_Task9_CalculatorUnitTesting {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        // Automatic test: 10 + 20
        int result = calc.add(10, 20);

        if (result == 30) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}