package CTCI.Chapter1;

/*
1.5 One Away
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check
if they are one edit (or zero edits) away.
 */
public class OneAway {

    public static boolean oneAway(String s1, String s2) {
        int sameFromStart = 0;
        int sameFromEnd = 0;

        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);
            if (s1Char == s2Char) {
                sameFromStart++;
            } else {
                break;
            }
        }

        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            char s1Char = s1.charAt(s1.length() - 1 - i);
            char s2Char = s2.charAt(s2.length() - 1 - i);
            if (s1Char == s2Char) {
                sameFromEnd++;
            } else {
                break;
            }
        }

        if (s1.length() == s2.length()) {
            return (sameFromStart == s1.length()) || (sameFromStart + sameFromEnd == s1.length() - 1);
        } else if (s1.length() == s2.length() + 1) {
            return sameFromStart + sameFromEnd == s2.length();
        } else if (s1.length() == s2.length() - 1) {
            return sameFromStart + sameFromEnd == s1.length();
        }

        return false;
    }

    public static void main(String[] args) {
        String[][] strings = {
                {"pale", "ple"},
                {"pales", "pale"},
                {"pale", "bale"},
                {"pale", "bake"},
                {"pale", "pale"}
        };

        for (String[] ss : strings) {
            System.out.println(oneAway(ss[0], ss[1]));
        }
    }
}
