package roy.coder.utils.algo.dp.knapsack.zero_one_knapsack.subsetsum;

import java.util.List;

public class SubsetSum {
    private boolean[][] dp;

    private final int n;
    private final int target;
    private final List<Integer> array;

    public SubsetSum(List<Integer> array, int target) {
        this.array = array;
        this.target = target;
        this.n = array.size();
    }

    private void initDP() {
        dp = new boolean[n + 1][target + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) dp[i][0] = true;
        for (int s = 1; s <= target; s++) dp[0][s] = false;
    }

    public boolean iterativeDP() {
        initDP();

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= target; s++) {
                if (array.get(i - 1) <= s) {
                    dp[i][s] = dp[i - 1][s - array.get(i - 1)] || dp[i - 1][s];
                } else dp[i][s] = dp[i - 1][s];
            }
        }

        return dp[n][target];
    }
}