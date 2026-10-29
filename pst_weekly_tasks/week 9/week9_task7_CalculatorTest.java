public class week9_task7_CalculatorTest {
    private week9_task6_Calculator cal = new week9_task6_Calculator();

    public void testAddition() {
        int result = cal.add(10, 20);
        if (result != 30) {
            throw new AssertionError("testAddition failed: expected 30, got " + result);
        }
        System.out.println("testAddition PASSED");
    }

    public void testDivision() {
        int result = cal.divide(20, 4);
        if (result != 5) {
            throw new AssertionError("testDivision failed: expected 5, got " + result);
        }
        System.out.println("testDivision PASSED");
    }

    public void testDivideByZero() {
        try {
            cal.divide(10, 0);
            throw new AssertionError("testDivideByZero failed: expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("testDivideByZero PASSED (" + e.getMessage() + ")");
        }
    }

    public static void main(String[] args) {
        week9_task7_CalculatorTest test = new week9_task7_CalculatorTest();
        System.out.println("Running Calculator Unit Tests:");
        test.testAddition();
        test.testDivision();
        test.testDivideByZero();
        System.out.println("All unit test cases executed successfully!");
    }
}
