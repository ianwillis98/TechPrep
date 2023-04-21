package hashing;

import java.util.*;

// https://leetcode.com/tag/hash-table/
public class LeetCodeHashTable {

    // https://leetcode.com/problems/jewels-and-stones/
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsCharacterIndex = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            char jewelsCharacter = jewels.charAt(i);
            jewelsCharacterIndex.add(jewelsCharacter);
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char stonesCharacter = stones.charAt(i);
            if (jewelsCharacterIndex.contains(stonesCharacter)) {
                count++;
            }
        }

        return count;
    }

    // https://leetcode.com/problems/number-of-good-pairs/
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numberCounts = new HashMap<>();
        int totalCount = 0;
        for (int num : nums) {
            if (numberCounts.containsKey(num)) {
                int count = numberCounts.get(num);
                totalCount += count;
                numberCounts.put(num, count + 1);
            } else {
                numberCounts.put(num, 1);
            }
        }
        return totalCount;
    }

    // https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cumulativeCounts = new int[101];
        for (int num : nums) {
            cumulativeCounts[num]++;
        }
        for (int i = 1; i < cumulativeCounts.length; i++) {
            cumulativeCounts[i] += cumulativeCounts[i - 1];
        }

        int[] smallerNumbersThanCurrent = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                smallerNumbersThanCurrent[i] = cumulativeCounts[num - 1];
            }
        }

        return smallerNumbersThanCurrent;
    }

    //https://leetcode.com/problems/design-an-ordered-stream/
    static class OrderedStream {
        int i;
        String[] map;

        public OrderedStream(int n) {
            i = 0;
            map = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            map[idKey - 1] = value;

            List<String> stream = new ArrayList<>();
            for (; i < map.length && map[i] != null; i++) {
                stream.add(map[i]);
            }

            return stream;
        }
    }

    //https://leetcode.com/problems/decode-the-message/
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        int count = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int code = c - 'a';
            if (code >= 0 && code <= 26 && map[code] == 0) {
                map[code] = (char) ('a' + count);
                count++;
            }
        }

        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int code = c - 'a';
            if (code >= 0 && code <= 26) {
                decoded.append(map[code]);
            } else {
                decoded.append(' ');
            }
        }

        return decoded.toString();
    }
}
