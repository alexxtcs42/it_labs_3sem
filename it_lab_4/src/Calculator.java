public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile("Деление на ноль");
            throw new CustomUnsupportedOperationException("Деление на ноль");
        }
        return a / b;
    }
}
