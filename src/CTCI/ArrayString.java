package CTCI;

import java.util.HashSet;
import java.util.Set;

public class ArrayString {

    /*
     1.1 Is Unique
     Implement an algorithm to determine if a String has all unique characters.
     What if you cannot use additional data structures?
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

    public static boolean isUniqueDoubleLoop(String value) {
        for (int i = 0; i < value.length(); i++) {
            for (int j = i + 1; j < value.length(); j++) {
                if (value.charAt(i) == value.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

}
