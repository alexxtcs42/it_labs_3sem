import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "abcd1234qWe7878";
        if (isPasswordValid(password)) {
            System.out.println("Пароль корректен");
        } else {
            System.out.println("Пароль некорректен");
        }
    }

    public static boolean isPasswordValid(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
