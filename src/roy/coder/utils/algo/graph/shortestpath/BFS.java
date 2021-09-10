package roy.coder.utils.algo.graph.shortestpath;

import roy.coder.utils.algo.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends FullPath {

    private static Graph g;
    private static Queue<Integer> q;
    public static List<Integer> distance;

    public static void run(Graph graph, int source) {
        g = graph;
        q = new LinkedList<>();
        distance = new ArrayList<>();
        FullPath.init(g.adjacencyList.size());
        for (int i = 0, sz = g.adjacencyList.size(); i < sz; ++i) distance.add(0);

        bfsUtil(source);
    }

    private static void bfsUtil(int s) {
        q.add(s);
        visited.set(s, true);
        while (!q.isEmpty()) {
            int u = q.poll();
            List<Integer> adjacencyList = g.adjacencyList.get(u);
            for (int v : adjacencyList) {
                if (!visited.get(v)) {
                    q.add(v);
                    parent.set(v, u);
                    visited.set(v, true);
                    distance.set(v, distance.get(u) + 1);
                }
            }
        }
    }
}
