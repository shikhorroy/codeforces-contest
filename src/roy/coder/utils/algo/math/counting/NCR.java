package roy.coder.utils.algo.math.counting;

import roy.coder.utils.algo.math.Modulo;

public class NCR {
    private final int mod;
    private final int maxN;
    private long[] factorial;

    public NCR(int maxN, int mod) {
        this.mod = mod;
        this.maxN = maxN;

        genFactorials();
    }

    private void genFactorials() {
        this.factorial = new long[maxN + 1];

        factorial[0] = 1;
        for (int i = 1; i <= maxN; i++) factorial[i] = (factorial[i - 1] * i) % mod;
    }

    public int calculate(int n, int r) {
        if (n > this.maxN) throw new Error("n (= " + n + ") can't be greater than maxn(= " + this.maxN + ")");
        if (n < r) return 0;
        if (r == 0) return 1;

        Modulo modulo = new Modulo(mod);
        return (int) (modulo.div(factorial[n], modulo.mult(factorial[r], factorial[n - r])));
    }

    public int calculate(int r) {
        return calculate(maxN, r);
    }
}
