//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Palindrome {
    public Palindrome() {
    }

    public static void main(String[] args) {
        String[] arguments = new String[]{"madam", "racecar", "apple", "kayak", "song", "noon"};

        for(int i = 0; i < arguments.length; ++i) {
            String s = arguments[i];
            System.out.println(isPalindrome(s));
        }

    }

    public static String reverseString(String s) {
        char[] array = s.toCharArray();
        StringBuilder result = new StringBuilder();

        for(int i = array.length - 1; i >= 0; --i) {
            result.append(array[i]);
        }

        return result.toString();
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}
