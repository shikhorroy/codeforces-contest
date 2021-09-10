package roy.coder.utils.utility.series;

public class SeriesUtility {

    /**
     * ~ source: https://www.geeksforgeeks.org/calculate-xor-1-n/
     * Calculate xor from 1 to n, i.e. 1 ^ 2 ^ 3 ^ .... ^ n
     *
     * @param n - last number of the series.
     * @return xor all numbers from 1 to n
     */
    public static long xorTillN(long n) {
        if (n % 4 == 0) return n; // If n is a multiple of 4
        if (n % 4 == 1) return 1; // If n%4 gives remainder 1
        if (n % 4 == 2) return n + 1; // If n%4 gives remainder 2
        return 0; // If n%4 gives remainder 3
    }

    public static int xorTillN(int n) {
        return (int) xorTillN((long) n);
    }
}
