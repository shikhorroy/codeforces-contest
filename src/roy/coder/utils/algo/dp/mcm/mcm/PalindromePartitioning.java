package roy.coder.utils.algo.dp.mcm.mcm;

import java.util.Arrays;

public class PalindromePartitioning {

    private int[][] memo;
    public int minPartitions;
    private final String string;

    public PalindromePartitioning(String string) {
        this.string = string;

        int ln = string.length();
        initMemo(ln);
        this.minPartitions = this.recursiveDP(0, ln - 1);
    }

    private void initMemo(int ln) {
        memo = new int[ln + 1][ln + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
    }

    private int recursiveDP(int i, int j) {
        if (i >= j || isPalindrome(i, j)) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int minPartitions = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int partitionsCount = recursiveDP(i, k) + recursiveDP(k + 1, j) + 1;
            minPartitions = Math.min(minPartitions, partitionsCount);
        }
        return memo[i][j] = minPartitions;
    }

    private boolean isPalindrome(int i, int j) {
        while (i < j) if (string.charAt(i++) != string.charAt(j--)) return false;
        return true;
    }
}
