package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;
import roy.coder.utils.utility.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormingQuizTeams {
    int n;
    double[] memo;
    double[][] cost;
    List<Pair<Integer, Integer>> coordinates;

    boolean isAvailable(int mask, int i) {
        return ((mask & (1 << i)) == 0);
    }

    double createGroup(int mask) {
        if (mask == (1 << n) - 1) return 0;
        if (memo[mask] != -1) return memo[mask];

        double ans = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (isAvailable(mask, i)) for (int j = 0; j < n; j++) {
                if (i != j && isAvailable(mask, j)) {
                    ans = Math.min(ans, cost[i][j] + createGroup(mask | (1 << i) | (1 << j)));
                }
            }
        }
        return memo[mask] = ans;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            n = in.readInteger() << 1;
            if (n == 0) return;
            coordinates = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                in.readString();
                int x = in.readInteger();
                int y = in.readInteger();
                coordinates.add(Pair.of(x, y));
            }

            cost = new double[n][n];
            for (int i = 0; i < n; i++) {
                Pair<Integer, Integer> point1 = coordinates.get(i);
                for (int j = 0; j < n; j++) {
                    Pair<Integer, Integer> point2 = coordinates.get(j);
                    cost[i][j] = Math.hypot(point1.first - point2.first, point1.second - point2.second);
                }
            }

            memo = new double[1 << n + 1];
            Arrays.fill(memo, -1);
            out.printLine(String.format("Case %d: %.02f", testNumber++, createGroup(0)));
        }
    }
}
