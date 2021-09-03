package roy.coder.utils.algo.math;

import java.math.BigInteger;

public class LCM {
    public static <T extends Number> T of(T a, T b) {
        BigInteger A = new BigInteger(a.toString());
        BigInteger B = new BigInteger(b.toString());

        BigInteger gcdOfAB = A.gcd(B);
        BigInteger lcmOfAB = A.divide(gcdOfAB).multiply(B);

        if (a instanceof Integer) return (T) Integer.valueOf(lcmOfAB.intValue());
        return (T) Long.valueOf(lcmOfAB.longValue());
    }
}
