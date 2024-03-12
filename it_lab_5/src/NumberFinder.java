import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19 999.99, or maybe 20, or maybe 0,7 or 1 more";
        Pattern pattern = Pattern.compile("-?\\d+([.,]\\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
