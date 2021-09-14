package roy.coder.utils.algo.dp.longest_common_subsequence;

/**
 * Algorithm: Longest Common Subsequence (LCS).
 */
public class LCS {

    private final int m, n;
    private final int[][] dp;
    private final String string1;
    private final String string2;

    public LCS(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;

        m = string1.length();
        n = string2.length();

        dp = new int[m + 1][n + 1];
    }

    /**
     * Complexity: O(m x n), where m = string1.length, n = string2.length.
     *
     * @return maximum length of longest common subsequence.
     */
    public int iterativeDP() {
        //~ step 01: initialization
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) dp[i][0] = 0;
        for (int i = 1; i <= n; i++) dp[0][i] = 0;

        //~ step 02: apply choice diagram
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[m][n];
    }

    public int[][] getDp() {
        return dp;
    }
}
