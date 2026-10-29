public class week9_task6_Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0)
            throw new IllegalArgumentException("Division by zero");
        return a / b;
    }
}
