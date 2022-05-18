package roy.coder.utils.utility;

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
        return (int) (1 + Math.log(v) / Math.log(base));
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
        return (int) (1 + Math.log(v) / Math.log(10));
    }
}
