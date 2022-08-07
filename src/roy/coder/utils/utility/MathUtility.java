package roy.coder.utils.utility;

import java.util.Collections;
import java.util.List;

public class MathUtility {

    public static <T> boolean isOdd(T number) {
        long longNumber = Long.parseLong(number.toString());
        return ((longNumber & 1) > 0);
    }

    public static <T> boolean isEven(T number) {
        long longNumber = Long.parseLong(number.toString());
        return ((longNumber & 1) == 0);
    }

    public static <T> boolean isPerfectSquare(T number) {
        long longNumber = Long.parseLong(number.toString());
        long squareRoot = (long) Math.sqrt(longNumber);
        return squareRoot * squareRoot == longNumber;
    }

    /**
     * This will give the # of digits needed for a number num in format : base.
     * time : O(1), space : O(1)
     *
     * @param number
     * @param base
     * @param <T>
     * @return
     */
    public static <T> int countDigits(T number, int base) {
        long v = Long.parseLong(number.toString());
        return (int) (1 + Math.log10(v) / Math.log10(base));
    }

    /**
     * This will give the # of digits needed for a number num in 10 base.
     * time : O(1), space : O(1)
     *
     * @param number
     * @param <T>
     * @return
     */
    public static <T> int countDigits(T number) {
        long v = Long.parseLong(number.toString());
        return (int) (1 + Math.log10(v) / Math.log10(10));
    }

    /**
     * Given a List, the task is to find the next lexicographically greater permutation.
     * <p>
     * Source: <a href="https://www.geeksforgeeks.org/implementing-next_permutation-in-java-with-examples/">click here</a>
     * <p>
     * Time Complexity: O(n!)
     *
     * @param list - list data.
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean findNextPermutation(List<T> list) {
        if (list == null || list.size() <= 1) return false;

        int last = list.size() - 2;
        while (last >= 0) {
            if (list.get(last).compareTo(list.get(last + 1)) < 0) break;
            last--;
        }

        if (last < 0) return false;
        int nextGreater = list.size() - 1;

        for (int i = list.size() - 1; i > last; i--) {
            if (list.get(i).compareTo(list.get(last)) > 0) {
                nextGreater = i;
                break;
            }
        }

        Collections.swap(list, nextGreater, last);

        int left = last + 1, right = list.size() - 1;
        while (left < right) {
            Collections.swap(list, left, right);
            left++;
            right--;
        }
        return true;
    }

    /**
     * Find if a number is power of 2.
     *
     * @param n numbers to check
     * @return boolean
     */
    public boolean isPowerOf2(long n) {
        return (n != 0 && (n & (n - 1)) == 0);
    }
}
