package roy.coder;

import roy.coder.utils.algo.math.primes.Sieve;
import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.List;

public class UVa1213_Sum_of_Different_Primes {

    List<Integer> primes;
    int[][][] dp;

    int recursiveMemoization(int n, int k, int i) {
        if (dp[n][k][i] != -1) return dp[n][k][i];

        if (k == 0) {
            if (n == 0) return 1;
            return 0;
        }
        if (n == 0 || i == 0) return 0;

        int taken = 0, skipped;
        if (primes.get(i - 1) <= n) {
            taken = recursiveMemoization(n - primes.get(i - 1), k - 1, i - 1);
        }
        skipped = recursiveMemoization(n, k, i - 1);

        return dp[n][k][i] = taken + skipped;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        Sieve sieve = new Sieve(1120);
        primes = sieve.getPrimes();
        while (true) {
            int n = in.readInteger();
            int k = in.readInteger();
            if (n == 0 && k == 0) break;
            dp = new int[n + 1][k + 1][primes.size() + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    for (int l = 0, sz = primes.size(); l <= sz; l++) {
                        dp[i][j][l] = -1;
                    }
                }
            }

            out.printLine(recursiveMemoization(n, k, primes.size()));
        }
    }
}
