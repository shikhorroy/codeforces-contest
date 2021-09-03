package roy.coder.utils.algo.math;

import java.math.BigInteger;

public class GCD {

    public static <T extends Number> T of(T a, T b) {
        BigInteger A = new BigInteger(a.toString());
        BigInteger B = new BigInteger(b.toString());

        BigInteger gcd = A.gcd(B);
        if (a instanceof Integer) return (T) Integer.valueOf(gcd.intValue());
        return (T) Long.valueOf(gcd.longValue());
    }
}
