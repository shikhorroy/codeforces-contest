package roy.coder.utils.algo.graph.dfs;

import roy.coder.utils.algo.graph.Graph;

import java.util.List;

public class Dfs {

    private static Graph g;
    private static boolean visited[];

    public boolean[] getVisited() {
        return visited;
    }

    public static void run(Graph graph, int source) {
        g = graph;
        visited = new boolean[g.adjacencyList.length];
        DfsUtil(source);
    }

    private static void DfsUtil(int u) {
        System.out.print(u + " ");

        visited[u] = true;
        List<Integer> list = g.adjacencyList[u];

        for (int v : list) {
            if (!visited[v]) {
                DfsUtil(v);
            }
        }
    }

}
