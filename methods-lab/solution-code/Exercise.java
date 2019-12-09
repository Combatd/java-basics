/**
 * Foundational Java: Solutions to Methods Lab
 *
 * @author Amell Peralta
 * @version 1.0 09/26/2019
 */

import java.util.List;
import java.util.ArrayList;

public class Exercise {
    public static void main(String[] args) {
        System.out.println("** Methods Lab: Tests **");
        System.out.println(maxOfTwoNumbers(20, 30));
        System.out.println(maxOfThree(60, 32, 42));

        System.out.println(isCharacterAVowel('A'));
        System.out.println(isCharacterAVowel('a'));
        System.out.println(isCharacterAVowel('P'));

        System.out.println(countArguments(20, 30));
        System.out.println(countArguments(5, 10, 15, 20));

        System.out.println(reverseString("Orange"));

        String[] words = {"Tomato", "Banana", "Apple", "Car", "Skulduggery"};
        System.out.println(findLongestWord(words));

        System.out.println(filterLongWords(words, 5));
    }

    public static int maxOfTwoNumbers(int number1, int number2) {
        return number1 > number2 ? number1 : number2;
    }

    public static int maxOfThree(int number1, int number2, int number3) {
        return number1 > number2 && number1 > number3 ? number1 : number2 > number3 ? number2 : number3;
    }

    public static boolean isCharacterAVowel(char c) {
        return "AEIOUaeiou".contains(String.valueOf(c));
    }

    public static int countArguments(int... args) {
        return args.length;
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /** Bonus */

    public static int findLongestWord(String[] words) {
        int result = 0;
        for (String word : words)
            result = Math.max(result, word.length());
        return result;
    }

    public static List<String> filterLongWords(String[] words, int i) {
        List<String> result = new ArrayList<>();
        for (String word : words)
            if (word.length() > i)
                result.add(word);
        return result;
    }
}
