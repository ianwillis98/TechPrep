package CTCI.Chapter1;

/*
1.6 String Compression
Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabccccaaa would become a2b1c4a3.
If the "compressed" string would not become smaller than the original string, your method
should return the original string. You can assume the string has only uppercase and lowercase letters (a-z).
 */
public class StringCompression {

    public static String compress(String s) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 1;
            int next = i + 1;
            while (next < s.length() && s.charAt(next) == c) {
                count++;
                next++;
            }
            i += count - 1;
            compressed.append(c).append(count);
        }

        if (compressed.length() < s.length()) {
            return compressed.toString();
        } else {
            return s;
        }
    }

    public static String compressBookSolution(String s) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < s.length(); i++) {
            countConsecutive++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressed.append(s.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return (compressed.length() < s.length()) ? compressed.toString() : s;
    }

    public static String compressUpfrontCount(String s) {
        int finalLength = finalLength(s);
        if (finalLength >= s.length()) return s;

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for (int i = 0; i < s.length(); i++) {
            countConsecutive++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressed.append(s.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.toString();
    }

    private static int finalLength(String s) {
        int finalLength = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                finalLength += 1 + String.valueOf(count).length();
                count = 0;
            }
        }

        return finalLength;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "aabbbcccccaaa",
                "abcdefg",
                "aabbbbbbbbbbcc"
        };

        for (String input : inputs) {
            System.out.println(compress(input));
            System.out.println(compressBookSolution(input));
            System.out.println(compressUpfrontCount(input));
        }
    }
}
