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
}
