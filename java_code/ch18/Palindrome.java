package Chapter_18;

import java.util.Scanner;

public class Palindrome {

    public static String result = "";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        String test = removeExtraCharacters(text);
        String test2 = reverseText(test, test.length() - 1);

        boolean finalResult = isPalindrom(test, test2);

        System.out.printf("test text: %s  reverse text test: %s%n", test, test2);
        System.out.printf("%n\"%s\" %s pallindrom", text, (finalResult == true) ? "is" : "is not");

        input.close();
    }

    public static String removeExtraCharacters(String text) {

        String result = "";
        int i = 0;
        while (i < text.length()) {

            result += (Character.isLetter(text.charAt(i))) ? text.charAt(i) + "" : "";

            i++;
        }

        return result;
    }

    public static String reverseText(String text, int x) {

        if (x == 0)
            return text.charAt(x) + "";
        else
            Palindrome.result += (text.charAt(x) + "") + reverseText(text, x - 1) + "";

        return Palindrome.result;
    }

    public static boolean isPalindrom(String text1, String text2) {

        if (text1.equals(text2))
            return true;
        else
            return false;
    }
}
