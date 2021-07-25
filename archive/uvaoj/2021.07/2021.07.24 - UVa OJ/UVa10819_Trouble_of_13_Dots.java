package roy.coder;

import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UVa10819_Trouble_of_13_Dots {

    private int[][] dp;
    private List<Integer> price;
    private List<Integer> favour;

    private int zeroOneKnapsack(int maxAmount, int cost, int index) {
        if (maxAmount <= 1800) {
            if (cost > maxAmount) return Integer.MIN_VALUE;
        } else {
            if (cost > maxAmount + 200) return Integer.MIN_VALUE;

            if (index == price.size()) {
                if (cost > maxAmount && cost <= 2000) {
                    return Integer.MIN_VALUE;
                }
                return 0;
            }
        }
        if (dp[index][cost] != -1) return dp[index][cost];

        return dp[index][cost] = Math.max(
                zeroOneKnapsack(maxAmount, cost, index + 1),
                favour.get(index) + zeroOneKnapsack(maxAmount, cost + price.get(index), index + 1)
        );
    }

    public void solve(int testNumber, Scanner in, OutputWriter out) {
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();

            price = new ArrayList<>();
            favour = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                price.add(in.nextInt());
                favour.add(in.nextInt());
            }

            dp = new int[n + 1][m + 5000];
            for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
            out.printLine(zeroOneKnapsack(m, 0, 0));
        }
    }
}
