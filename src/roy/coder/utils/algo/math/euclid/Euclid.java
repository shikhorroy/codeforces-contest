package roy.coder.utils.algo.math.euclid;

public class Euclid {
    /**
     * Complexity: O(log(min(a, b))
     */
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    //~~ Extended Euclid ~~// START //
    public static class Tuple {
        public long g, x, y;

        public Tuple(long g, long x, long y) {
            this.g = g;
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Given a and b. Let g = gcd(a, b).
     * <p>
     * Then we can write,  ax + by = g.
     * <p>
     * Extended GCD finds these x and y.
     */
    public static Tuple extendedGCD(long a, long b) {
        if (b == 0) return new Tuple(a, 1, 0);

        Tuple curr = extendedGCD(b, a % b);
        long prevY = curr.y;
        curr.y = curr.x - (a / b) * (curr.y);
        curr.x = prevY;
        return curr;
    }
    //~~ Extended Euclid ~~// END //

    public static long moduloInverse(long a, long mod) {
        return extendedGCD(a, mod).x;
    }
}
