package roy.coder.utils.algo.dp.knapsack.un_bounded_knapsack;

import java.util.List;

public class RodCutting {
    private int[][] dp;

    private final int n;
    private final int length;
    private final List<Integer> prices;
    private final List<Integer> lengths;

    public RodCutting(int length, List<Integer> lengths, List<Integer> prices) {
        this.prices = prices;
        this.lengths = lengths;
        this.n = lengths.size();
        this.length = length;
    }

    private void initDp() {
        dp = new int[n + 1][length + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) dp[i][0] = 0;
        for (int c = 1; c <= length; c++) dp[0][c] = 0;
    }

    public int iterativeDP() {
        initDp();

        for (int i = 1; i <= n; i++) {
            for (int l = 1; l <= length; l++) {
                if (lengths.get(i - 1) <= l) {
                    dp[i][l] = Math.max(
                            prices.get(i - 1) + dp[i][l - lengths.get(i - 1)],
                            dp[i][l] = dp[i - 1][l]
                    );
                } else dp[i][l] = dp[i - 1][l];
            }
        }

        return dp[n][length];
    }
}
