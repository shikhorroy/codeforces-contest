package roy.coder.utils.algo.dp.mcm.mcm;

import java.util.Arrays;
import java.util.List;

public class MCM {

    public int minCost;
    private int[][] memo;
    private final List<Integer> dimensions;

    public MCM(List<Integer> dimensions) {
        this.dimensions = dimensions;

        int sz = dimensions.size();
        this.initMemo(sz);
        this.minCost = recursiveDP(1, sz - 1);
    }

    private void initMemo(int sz) {
        memo = new int[sz + 1][sz + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
    }

    private int recursiveDP(int i, int j) {
        if (i >= j) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int currCost = recursiveDP(i, k) + recursiveDP(k + 1, j)
                    + dimensions.get(i - 1) * dimensions.get(k) * dimensions.get(j);
            minCost = Math.min(minCost, currCost);
        }
        return memo[i][j] = minCost;
    }
}
