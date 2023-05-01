package CTCI.Chapter1;

import java.util.HashSet;
import java.util.Set;

/*
 * 1.1 Is Unique
 * Implement an algorithm to determine if a String has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    /*
     * O(n) space and time
     * Hash table supports all characters
     */
    public static boolean isUniqueWithHashTable(String value) {
        Set<Character> previouslySeenCharacters = new HashSet<>();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (previouslySeenCharacters.contains(c)) {
                return false;
            } else {
                previouslySeenCharacters.add(c);
            }
        }

        return true;
    }

    public static boolean isUniqueAscii(String value) {
        if (value.length() > 256) return false;

        boolean[] previouslySeenCharacters = new boolean[256];

        for (int i = 0; i < value.length(); i++) {
            int c = value.charAt(i);
            if (previouslySeenCharacters[c]) {
                return false;
            } else {
                previouslySeenCharacters[c] = true;
            }
        }

        return true;
    }

    public static boolean isUniqueLowerCaseAlpha(String value) {
        int previouslySeenCharacters = 0;

        for (int i = 0; i < value.length(); i++) {
            int c = value.charAt(i) - 'a';
            if (((previouslySeenCharacters >> c) & 1) == 1) {
                return false;
            } else {
                previouslySeenCharacters = previouslySeenCharacters | (1 << c);
            }
        }

        return true;
    }

    public static boolean isUniqueNoExtraSpace(String value) {
        for (int i = 0; i < value.length(); i++) {
            for (int j = i + 1; j < value.length(); j++) {
                if (value.charAt(i) == value.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUniqueSorting(String value) {
        char[] characters = value.toCharArray();

        // TODO in-place heap sort

        return false;
    }

    public static void main(String[] args) {
        String[] values = { "abcdefghijk", "abcdefa" };

        for (String value : values) {
            System.out.println(isUniqueWithHashTable(value));
            System.out.println(isUniqueAscii(value));
            System.out.println(isUniqueLowerCaseAlpha(value));
            System.out.println(isUniqueNoExtraSpace(value));
        }
    }
}
