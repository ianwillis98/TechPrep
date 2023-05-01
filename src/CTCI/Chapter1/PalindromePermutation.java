package CTCI.Chapter1;

import java.util.HashMap;
import java.util.Map;

/*
1.4 Palindrome Permutation
Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangements of letters. The palindrome does not need to be limited to just
dictionary words. You can ignore casing and non-letter characters
 */
public class PalindromePermutation {

    public static boolean palindromePermutation(String s) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c < 'a' || c > 'z') continue;

            Integer count = characterCounts.get(c);
            if (count == null) {
                characterCounts.put(c, 1);
            } else {
                characterCounts.put(c, count + 1);
            }
        }

        boolean foundOdd = false;
        for (Integer value : characterCounts.values()) {
            if (value % 2 != 0) {
                if (!foundOdd) {
                    foundOdd = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean palindromePermutationArray(String s) {
        int[] characterCounts = new int[('z' - 'a') + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') continue;

            characterCounts[c - 'a']++;
        }

        boolean foundOdd = false;
        for (int count : characterCounts) {
            if (count % 2 != 0) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static boolean palindromePermutationBitVector(String s) {
        int characterCounts = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') continue;

            int pos = c - 'a';
            int bitMask = 1 << pos;
            characterCounts ^= bitMask;
        }

        boolean foundOdd = false;
        for (int i = 0; i < 32; i++) {
            if (((characterCounts >> i) & 1) == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "tact coa";
        String s2 = "tact coat";

        System.out.println(palindromePermutation(s1));
        System.out.println(palindromePermutation(s2));
        System.out.println(palindromePermutationArray(s1));
        System.out.println(palindromePermutationArray(s2));
        System.out.println(palindromePermutationBitVector(s1));
        System.out.println(palindromePermutationBitVector(s2));
    }
}
