import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";
        if (validateIP(ipAddress)) {
            System.out.println("IP адрес корректен");
        } else {
            System.out.println("IP адрес некорректен");
        }
    }

    private static final Pattern pattern = Pattern.compile(
            "^([0-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])" +
            "\\.([0-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])" +
            "\\.([0-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])" +
            "\\.([0-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])$"
    );

    public static boolean validateIP(String ip) {
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
