package roy.coder;

import roy.coder.utils.algo.dp.zero_one_knapsack.ZeroOneKnapsack;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVa990_Diving_for_gold {
    public void solve(int testNumber, Scanner in, OutputWriter out) {
        boolean newLine = false;
        while (in.hasNext()) {
            if (newLine) out.printLine(); newLine = true;

            List<Integer> d = new ArrayList<>();
            List<Integer> v = new ArrayList<>();
            List<Integer> cost = new ArrayList<>();

            int t = in.nextInt();
            int w = in.nextInt();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                d.add(in.nextInt());
                v.add(in.nextInt());
                cost.add(3 * w * d.get(i));
            }

            ZeroOneKnapsack knapsack = new ZeroOneKnapsack(cost, v, t);
            out.printLine(knapsack.iterativeDP());
            int[][] dp = knapsack.getDp();
            int takenItemsCount = 0;
            List<Integer> indexOfTakenTreasure = new ArrayList<>();
            for (int i = n; i > 0; i--) {
                if (dp[i][t] != dp[i - 1][t]) {
                    takenItemsCount++;
                    indexOfTakenTreasure.add(i - 1);
                    t -= cost.get(i - 1);
                }
            }
            out.printLine(takenItemsCount);
            for (int i = indexOfTakenTreasure.size() - 1; i >= 0; i--) {
                int index = indexOfTakenTreasure.get(i);
                out.printLine(d.get(index) + " " + v.get(index));
            }
        }
    }
}
