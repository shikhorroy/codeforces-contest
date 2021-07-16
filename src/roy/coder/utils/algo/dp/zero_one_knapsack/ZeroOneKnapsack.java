package roy.coder.utils.algo.dp.zero_one_knapsack;

import java.util.ArrayList;
import java.util.List;

public class ZeroOneKnapsack {

    private Integer knapsackCapacity;//~ how much weight the knapsack can carry.
    //~ arrays to store item information:
    private List<Integer> weight = new ArrayList<>();
    private List<Integer> value = new ArrayList<>();

    //~ final tabular matrix of dp solution:
    private int[][] dp;

    /**
     * Given, the weights of n items, values of n items and the max capacity of a knapsack.
     * We have to choose items with max of knapsack capacity so that, total value
     * will be maximized. We have options to choose or not to choose the whole item, we can't take fraction of the
     * ith item.
     *
     * @param weight           weights of n items.
     * @param value            values of n items.
     * @param knapsackCapacity max weight the knapsack can carry.
     */
    public ZeroOneKnapsack(List<Integer> weight, List<Integer> value, Integer knapsackCapacity) {
        if (weight != null) this.weight = weight;
        if (value != null) this.value = value;
        if (knapsackCapacity != null) this.knapsackCapacity = knapsackCapacity;

        if (knapsackCapacity != null && weight != null) {
            dp = new int[weight.size() + 1][knapsackCapacity + 1];
        }
    }

    public int[][] getDp() {
        return dp;
    }

    public int iterativeDP() {
        //~ step 01: initialization:
        int n = weight.size();
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0; //~ if knapsack capacity is 0 then max profit we can make by taking till ith item is 0
        for (int c = 0; c <= knapsackCapacity; c++)
            dp[0][c] = 0; //~ if no item to select, then whatever the capacity of the knapsack, we can make 0 profit

        //~ step 02: choice diagram implementation:
        for (int i = 1; i <= n; i++) {//~ index of all items
            for (int c = 1; c <= knapsackCapacity; c++) {//~ try all capacity
                if (weight.get(i - 1) <= c) {
                    dp[i][c] = Math.max(
                            value.get(i - 1) + dp[i - 1][c - weight.get(i - 1)],
                            dp[i - 1][c]
                    );
                } else dp[i][c] = dp[i - 1][c];
            }
        }

        return this.maxProfit();
    }

    public int maxProfit() {
        return dp[weight.size()][knapsackCapacity];
    }
}
