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

    public static boolean isPerfectSquare(long number) {
        long squareRoot = (long) Math.sqrt(number);
        return squareRoot * squareRoot == number;
    }

    /**
     * Find max values among integer or long values.
     *
     * @param values - among where max value need to find.
     * @return maximum among values.
     */
    public static long max(long... values) {
        long max = values[0];
        for (int i = 1; i < values.length; i++)
            if (values[i] > max) max = values[i];
        return max;
    }

    /**
     * Find min values among integer or long values.
     *
     * @param values - among where min value need to find.
     * @return minimum among values.
     */
    public static long min(long... values) {
        long min = values[0];
        for (int i = 1; i < values.length; i++)
            if (values[i] < min) min = values[i];
        return min;
    }

    /**
     * This will give the # of digits needed for a number num in format : base.
     * time : O(1), space : O(1)
     */
    public static int countDigits(long number, int base) {
        return (int) (1 + Math.log10(number) / Math.log10(base));
    }

    /**
     * This will give the # of digits needed for a number num in 10 base.
     * time : O(1), space : O(1)
     */
    public static int countDigits(long number) {
        return (int) (1 + Math.log10(number) / Math.log10(10));
    }

    /**
     * Given a List, the task is to find the next lexicographically greater permutation.
     * <p>
     * Source: <a href="https://www.geeksforgeeks.org/implementing-next_permutation-in-java-with-examples/">click here</a>
     * <p>
     * Time Complexity: O(n!)
     *
     * @param list - list data.
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
    public static boolean isPowerOf2(long n) {
        return (n != 0 && (n & (n - 1)) == 0);
    }

    public static boolean isFibonacci(long n) {
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }


    /**
     * Sqrt(n) complexity solution.
     */
    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;

        return true;
    }

    /**
     * Sqrt(n) complexity solution.
     */
    public static boolean isComposite(long n) {
        if (n <= 2) return false;
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0) return true;

        return false;
    }

    public static int trailingZerosOfFactorial(long n) {
        int zeros = 0;
        long multipleOf5 = 5;
        while (multipleOf5 <= n) {
            zeros += n / multipleOf5;
            multipleOf5 *= 5;
        }
        return zeros;
    }

    public static int countDigitsOfFactorial(int n) {
        if (n < 0) return 0;
        if (n <= 1) return 1;

        double digits = 0;
        for (int x = 2; x <= n; x++) digits += Math.log10(x);
        return (int) (Math.floor(digits)) + 1;
    }
}
