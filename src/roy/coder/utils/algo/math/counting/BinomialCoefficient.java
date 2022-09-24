package roy.coder.utils.algo.math.counting;

// Complexity: O(n^2)
public class BinomialCoefficient {

    public static long[][] calculate(int maxn) {
        long[][] C = new long[maxn + 1][maxn + 1];
        C[0][0] = 1;

        for (int n = 1; n <= maxn; ++n) {
            C[n][0] = C[n][n] = 1;
            for (int k = 1; k < n; ++k)
                C[n][k] = C[n - 1][k - 1] + C[n - 1][k];
        }
        return C;
    }
}
