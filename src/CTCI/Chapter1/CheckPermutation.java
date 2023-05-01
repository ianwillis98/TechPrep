package CTCI.Chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1.2 Check Permutation
Given two strings, write a method to decide if one is a permutation of the other
 */
public class CheckPermutation {

    /*
    n space
    n time
     */
    public static boolean checkPermutationCounting(String value1, String value2) {
        if (value1.length() != value2.length()) return false;

        Map<Character, Integer> characterCounts = new HashMap<>();
        for (int i = 0; i < value1.length(); i++) {
            char c = value1.charAt(i);
            if (characterCounts.containsKey(c)) {
                characterCounts.put(c, characterCounts.get(c) + 1);
            } else {
                characterCounts.put(c, 1);
            }
        }

        for (int i = 0; i < value2.length(); i++) {
            char c = value2.charAt(i);
            Integer count = characterCounts.get(c);
            if (count == null || count == 0) {
                return false;
            } else {
                characterCounts.put(c, count - 1);
            }
        }

        return true;
    }

    /*
    n lg n time
    n space (in place sorting could reduce to 1)
     */
    public static boolean checkPermutationSorting(String value1, String value2) {
        char[] value1Arr = value1.toCharArray();
        char[] value2Arr = value2.toCharArray();

        Arrays.sort(value1Arr);
        Arrays.sort(value2Arr);


        return Arrays.equals(value1Arr, value2Arr);
    }

    public static void main(String[] args) {
        String[] values = {
                "abcdefghijk", "kbcdefghijaa",
                "abcdefghijk", "kbcdefghija",
                "abcdefghijk", "kbcdefghij",
        };

        for (int i = 0; i < values.length; i += 2) {
            System.out.println(checkPermutationCounting(values[i], values[i + 1]));
            System.out.println(checkPermutationSorting(values[i], values[i + 1]));
        }
    }
}
