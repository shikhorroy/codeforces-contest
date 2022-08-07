package roy.coder.utils.utility.bit;

public class BitManipulation {

    public static long setBit(long x, int nth) {
        return (x | (1L << nth));
    }

    public static long resetBit(long x, int nth) {
        return (x & ~(1L << nth));
    }

    public static boolean isSet(long x, int nth) {
        return (x & (1L << nth)) > 0;
    }

    public static long toggle(long x, int nth) {
        return (x ^ (1L << nth));
    }
}
