package roy.coder.utils.utility;

public class MathUtility {

    public static boolean isPerfectSquare(long num) {
        long squareRoot = (long) Math.sqrt(num);
        return squareRoot * squareRoot == num;
    }

    public static boolean isPerfectSquare(int num) {
        return isPerfectSquare((long) num);
    }

    public static boolean isEven(int number) {
        return isEven((long) number);
    }

    public static boolean isEven(long number) {
        return ((number & 1) == 0);
    }

    public static boolean isOdd(int number) {
        return isOdd((long) number);
    }

    public static boolean isOdd(long number) {
        return ((number & 1) > 0);
    }
}
