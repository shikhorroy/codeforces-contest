package roy.coder;

import roy.coder.utils.algo.dp.knapsack.zero_one_knapsack.SubsetSum;
import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class UVa_562_Dividing_coins {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInteger();
        for (int cs = 0; cs < n; cs++) {
            int m = in.readInteger();
            List<Integer> array = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < m; i++) {
                int x = in.readInteger();
                sum += x;
                array.add(x);
            }
            SubsetSum soln = new SubsetSum(array, sum);
            soln.iterativeDP();
            boolean[][] dp = soln.getDp();
            int ans = Integer.MAX_VALUE;
            for (int s = 0, sz = array.size(); s <= sum / 2; s++) {
                if (dp[sz][s]) {
                    ans = Math.min(sum - s - s, ans);
                }
            }
            if (ans == Integer.MAX_VALUE) out.printLine();
            else out.printLine(ans);
        }
    }
}
