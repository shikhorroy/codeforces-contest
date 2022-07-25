# Miscellaneous

### Game

> ### [[CSES] Removal Game](https://cses.fi/problemset/task/1097)

```java
//~ Solution: Top down DP
static class RemovalGame {
    long[][] dp;
    int[] numbers;

    long play(int start, int end) {
        if (start > end) return 0;
        if (dp[start][end] != -1) return dp[start][end];

        return dp[start][end] = Math.max(
                numbers[start] + Math.min(play(start + 2, end), play(start + 1, end - 1)),
                numbers[end] + Math.min(play(start + 1, end - 1), play(start, end - 2))
        );
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInteger();
        numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = in.readInteger();

        dp = new long[n][n];
        for (long[] d : dp) Arrays.fill(d, -1L);

        out.printLine(play(0, n - 1));
    }
}
```