package roy.coder.utils.algo.math;

import java.math.BigInteger;

public class Modulo {

    private final int mod;

    public Modulo(int mod) {
        this.mod = mod;
    }

    /**
     * Calculate x % m
     */
    public long mod(long x) {
        return ((x % mod + mod) % mod);
    }

    /**
     * Calculate (a + b) % m
     */
    public long add(long a, long b) {
        return mod(mod(a) + mod(b));
    }

    /**
     * Calculate (a - b) % m
     */
    public long sub(long a, long b) {
        return mod(mod(a) - mod(b));
    }

    /**
     * Calculate (a * b) % m
     */
    public long mult(long a, long b) {
        return mod(mod(a) * mod(b));
    }

    /**
     * Calculate (a / b ) % m
     */
    public long div(long a, long b) {
        // (a % m * (1 / b) % m) % m
        return mod(mod(a) * inverse(b));
    }

    /**
     * Calculate a<sup>-1</sup> % m
     */
    public long inverse(long a) {
        return BigInteger.valueOf(a)
                .modInverse(BigInteger.valueOf(this.mod))
                .longValue();
    }
}
