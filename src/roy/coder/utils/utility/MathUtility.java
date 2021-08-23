package roy.coder.utils.utility;

public class MathUtility {

    public static boolean isPerfectSquare(long num) {
        long squareRoot = (long) Math.sqrt(num);
        return squareRoot * squareRoot == num;
    }

    public static boolean isPerfectSquare(int num) {
        return isPerfectSquare((long) num);
    }
}
