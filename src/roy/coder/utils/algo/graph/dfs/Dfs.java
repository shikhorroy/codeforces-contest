package roy.coder.utils.algo.graph.dfs;

import roy.coder.utils.algo.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class Dfs {

    private static Graph g;
    public static List<Boolean> visited;

    public static void run(Graph graph, int source) {
        g = graph;
        visited = new ArrayList<>();
        for (int i = 0, sz = g.adjacencyList.size(); i < sz; ++i) visited.add(false);

        dfsUtil(source);
    }

    private static void dfsUtil(int u) {
        System.out.print(u + " ");

        visited.set(u, true);
        List<Integer> list = g.adjacencyList.get(u);
        for (int v : list) if (!visited.get(v)) dfsUtil(v);
    }
}
