package roy.coder.utils.utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUtility {

    /**
     * Complexity: O(n^2)
     *
     * @param string - what need to sort alphabetically
     * @return alphabetically sorted string
     */
    public static String sort(String string) {
        char[] sa = string.toCharArray();
        Arrays.sort(sa);
        return new String(sa);
    }

    /**
     * Count character frequency
     * Complexity: O(n), n = length of string
     *
     * @param string - need to count frequency.
     * @return Map of characters count.
     */
    public static Map<Character, Integer> countFrequency(String string) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character c : string.toCharArray()) {
            if (!frequency.containsKey(c)) frequency.put(c, 0);
            frequency.put(c, frequency.get(c) + 1);
        }
        return frequency;
    }

    /**
     * Check if target string is a sub-sequence of source string.
     * Complexity: O(m x n), m - length of source string, n - length of target string
     *
     * @param source - where need to check
     * @param target is to check
     * @return true if target is a sub-sequence, false otherwise.
     */
    public static boolean isSubSequence(String source, String target) {
        int sourceLength = source.length(), targetLength = target.length();
        if (sourceLength < targetLength) return false;

        int targetIndex = 0, sourceIndex = 0;
        while (sourceIndex < sourceLength && targetIndex < targetLength) {
            char targetChar = target.charAt(targetIndex++);
            while (sourceIndex < sourceLength && source.charAt(sourceIndex++) != targetChar) ;
        }

        return (
                targetIndex == targetLength
                        && source.charAt(sourceIndex - 1) == target.charAt(targetIndex - 1) //~ source: abcde, target: acf

        );
    }
}
