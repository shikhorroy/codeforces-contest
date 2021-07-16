package roy.coder.utils.algo.dp.zero_one_knapsack;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    private Integer sum;
    private List<Integer> array = new ArrayList<>();

    private boolean[][] dp;

    public SubsetSum(List<Integer> array, Integer sum) {
        if (sum != null) this.sum = sum;
        if (array != null) this.array = array;

        if (sum != null && array != null) {
            dp = new boolean[array.size() + 1][sum + 1];
        }
    }

    public boolean[][] getDp() {
        return dp;
    }

    public boolean iterativeDP() {
        //~ step 01: initialization:
        int n = array.size();
        dp[0][0] = true;//~ it is possible to make 0 from 0 item
        for (int i = 1; i <= n; i++)
            dp[i][0] = true;//~ whatever items we have, we can make 0 from it without taking any
        for (int s = 1; s <= sum; s++) dp[0][s] = false;//~ we can't make anything with 0 item


        //~ step 02: choice diagram implementation:
        for (int i = 1; i <= n; i++) {//~ index of all items
            for (int s = 1; s <= sum; s++) {//~ try to make all possible sum
                if (array.get(i - 1) <= s) {//~ making an s is possible from x if x is <= s:
                    dp[i][s] = dp[i - 1][s - array.get(i - 1)]//~ we can take 3 to create 5 if (5 - 3 = 2) is possible
                            || dp[i - 1][s];//~ or we can skip the item
                } else dp[i][s] = dp[i - 1][s];//~ otherwise skip the item and put the earliest result
            }
        }

        return this.doesExist();
    }

    public boolean doesExist() {
        return dp[array.size()][sum];
    }
}