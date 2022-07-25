package roy.coder.utils.algo.dp.knapsack.zero_one_knapsack.zeroone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZeroOneKnapsack {
    private int[][] dp;

    private final int n;
    private final int capacity;
    private final List<Integer> values;
    private final List<Integer> weights;

    public ZeroOneKnapsack(int capacity, List<Integer> weights, List<Integer> values) {
        this.values = values;
        this.weights = weights;
        this.n = weights.size();
        this.capacity = capacity;
    }

    private void initDp() {
        dp = new int[n + 1][capacity + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) dp[i][0] = 0;
        for (int c = 1; c <= capacity; c++) dp[0][c] = 0;
    }

    public int iterativeDP() {
        initDp();

        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= capacity; c++) {
                if (weights.get(i - 1) <= c) {
                    dp[i][c] = Math.max(
                            values.get(i - 1) + dp[i - 1][c - weights.get(i - 1)],
                            dp[i][c] = dp[i - 1][c]
                    );
                } else dp[i][c] = dp[i - 1][c];
            }
        }

        return dp[n][capacity];
    }

    public List<Integer> indexOfSelectedItems() {
        List<Integer> indexList = new ArrayList<>();
        int profit = dp[n][capacity], cap = capacity;
        for (int i = n; i > 0 && profit > 0; i--) {
            if (profit == dp[i - 1][cap]) ;//~ do nothing
            else {
                indexList.add(i - 1);
                profit = profit - values.get(i - 1);
                cap = cap - weights.get(i - 1);
            }
        }
        Collections.reverse(indexList);
        return indexList;
    }
}
