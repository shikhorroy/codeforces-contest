package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Uva539_The_Settlers_of_Catan {

    private List<Integer>[] graph;
    private boolean[][] taken;
    private int maxLength;

    private void solve(int source, int length) {
        maxLength = Math.max(maxLength, length);
        if (graph[source] != null) for (Integer destination : graph[source]) {
            if (!taken[source][destination]) {
                taken[source][destination] = true;
                taken[destination][source] = true;

                solve(destination, length + 1);
                taken[source][destination] = false;
                taken[destination][source] = false;
            }
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {

            int n = in.readInteger();
            int m = in.readInteger();

            if (n == 0 && m == 0) return;

            graph = new ArrayList[n];
            for (int i = 0; i < m; i++) {
                int u = in.readInteger();
                int v = in.readInteger();

                if (graph[u] == null) graph[u] = new ArrayList<>();
                if (graph[v] == null) graph[v] = new ArrayList<>();
                graph[u].add(v);
                graph[v].add(u);
            }

            int ans = 0;
            for (int s = 0; s < n; s++) {
                maxLength = 0;
                taken = new boolean[n][n];
                for (boolean[] t : taken) Arrays.fill(t, false);

                solve(s, 0);
                ans = Math.max(maxLength, ans);
            }
            out.printLine(ans);
        }
    }
}
