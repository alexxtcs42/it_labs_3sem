import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите целое число: ");
            int num = scanner.nextInt();
            System.out.println("Вы ввели: " + num);
        } catch (CustomInputMismatchException e) {
            Logger ExceptionLogger = new Logger();
            ExceptionLogger.logToFile("Ошибка ввода: " + e.getMessage());
            throw new CustomInputMismatchException("Ошибка ввода: " + e.getMessage());
        }
        catch (InputMismatchException e) {
            try {
                throw new CustomInputMismatchException("Ошибка ввода");
            } catch (CustomInputMismatchException ex) {
                Logger ExceptionLogger = new Logger();
                ExceptionLogger.logToFile("Ошибка: " + ex.getMessage());
                throw new CustomInputMismatchException("Ошибка: " + ex.getMessage());
            }
        }
    }
}
