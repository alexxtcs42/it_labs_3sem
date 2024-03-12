import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;

public class Test {
    public static void main(String[] args) throws CustomAgeException, FileNotFoundException, CustomEmailFormatException {
        System.out.println(division(42, 0));
        System.out.println(validateAge(-1));
        System.out.println(fileReader(new File("nonExistentFile.txt")));
        System.out.println(parsing("not a number"));
        System.out.println(validateEmail("someEmail(sobaka)gmail.com"));
        System.out.println(stackPop(new CustomStack()));
        System.out.println(calculate(13, 0));
    }

    public static int division(int n, int m) throws CustomDivisionException {
        try {
            return n / m;
        }
        catch (CustomDivisionException e) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile(e.getMessage());
            throw e;
        }
        catch (java.lang.ArithmeticException e) {
            try {
                throw new CustomDivisionException("Деление на 0");
            } catch (CustomDivisionException ex) {
                Logger ExceptionLogger = new Logger();
                ExceptionLogger.logToFile("Ошибка: " + ex.getMessage());
                throw new CustomDivisionException("Ошибка: " + ex.getMessage());
            }
        }
    }

    public static String validateAge(int age) throws CustomAgeException {
        if ((age < 0) || (age > 120)) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile("Указан неверный возраст");
            throw new CustomAgeException("Указан неверный возраст");
        }
        else {
            return "Возраст указан верно";
        }
    }

    public static String fileReader(File file) throws FileNotFoundException {
        FileChannel src = null;
        try {
            src = new FileInputStream(file).getChannel();
            return "Файл был найден";
        }
        catch (CustomFileNotFoundException e) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile(e.getMessage());
            throw e;
        }
        catch (FileNotFoundException e) {
            try {
                throw new CustomFileNotFoundException("Файл был найден");
            } catch (CustomFileNotFoundException ex) {
                Logger ExceptionLogger = new Logger();
                ExceptionLogger.logToFile("Ошибка: " + ex.getMessage());
                throw new CustomFileNotFoundException("Ошибка: " + ex.getMessage());
            }
        }
    }

    public static Integer parsing(String s) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(s);
        }
        catch (CustomNumberFormatException e) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile(e.getMessage());
            throw e;
        }
        catch (NumberFormatException e) {
            try {
                throw new CustomNumberFormatException("Не число");
            } catch (CustomNumberFormatException ex) {
                Logger ExceptionLogger = new Logger();
                ExceptionLogger.logToFile("Ошибка: " + ex.getMessage());
                throw new CustomNumberFormatException("Ошибка: " + ex.getMessage());
            }
        }
    }

    public static String validateEmail(String email) throws CustomEmailFormatException {
        if (!email.contains("@")) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile("Некорректный адрес электронной почты");
            throw new CustomEmailFormatException("Некорректный адрес электронной почты");
        }
        else {
            return "Корректный адрес электронной почты";
        }
    }

    public static CustomStack stackPop(CustomStack stack) {
        stack.pop();
        return stack;
    }

    public static int calculate(int a, int b) {
        return Calculator.divide(a, b);
    }
}
