package CTCI.Chapter1;

/*
1.3 Urlify
Write a method to replace all spaces in a string with '%20'. You may assume that the string
have sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string.
 */
public class Urlify {

    /*
    n space
    n time
     */
    public static String urlifyExtraSpace(String s, int length) {
        char[] chars = s.toCharArray();

        int offset = 0;
        for (int i = 0; i < length; i++, offset++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[offset] = '%';
                chars[offset + 1] = '2';
                chars[offset + 2] = '0';
                offset += 2;
            } else {
                chars[offset] = c;
            }
        }

        return new String(chars);
    }

    public static String urlifyNoExtraSpace(char[] chars, int length) {
        int numSpaces = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                numSpaces++;
            }
        }

        int newIndex = (length - 1) + (numSpaces * 2);

        for (int oldIndex = length - 1; oldIndex >= 0; oldIndex--) {
            if (chars[oldIndex] == ' ') {
                chars[newIndex] = '0';
                chars[newIndex - 1] = '2';
                chars[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                chars[newIndex] = chars[oldIndex];
                newIndex -= 1;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s1 = "a b  ";
        String s2 = "a  b    ";
        String s3 = "a   b      ";

        System.out.println(urlifyExtraSpace(s1, 3));
        System.out.println(urlifyExtraSpace(s2, 4));
        System.out.println(urlifyExtraSpace(s3, 5));

        System.out.println(urlifyNoExtraSpace(s1.toCharArray(), 3));
        System.out.println(urlifyNoExtraSpace(s2.toCharArray(), 4));
        System.out.println(urlifyNoExtraSpace(s3.toCharArray(), 5));
    }
}
