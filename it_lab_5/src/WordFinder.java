import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder {
    public static void main(String[] args) {
        String text = "This is a sample text with some words. " +
                "Now we're gonna find all words starting with the letter 's'.";
        char startingLetter = 's';
        findWordsStartingWithLetter(text, startingLetter);
    }

    public static void findWordsStartingWithLetter(String text, char letter) {
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
