package roy.coder.utils.algo.math;

import java.math.BigInteger;

public class LCM {
    public static <T> T of(T a, T b) {
        BigInteger A = new BigInteger(a.toString());
        BigInteger B = new BigInteger(b.toString());

        BigInteger gcdOfAB = GCD.of(A, B);
        return (T) (A.divide(gcdOfAB).multiply(B));
    }
}
