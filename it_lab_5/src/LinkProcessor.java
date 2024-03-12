import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkProcessor {
    public static void main(String[] args) {
        String text = "Пример текста с ссылкой на google: https://www.google.com. " +
                "Вот ещё ссылка на yandex: https://ya.ru. На этом всё.";
        String processedText = processLinksInText(text);
        System.out.println(processedText);
    }

    public static String processLinksInText(String text) {
        Pattern pattern = Pattern.compile("(http(s?)://\\w+(\\.\\w+)+(/\\w*)*)");
        Matcher matcher = pattern.matcher(text);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String link = matcher.group(1);
            String replacement = "<a href=\"" + link + "\">" + link + "</a>";
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
