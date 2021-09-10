package roy.coder.utils.algo.graph.shortestpath;

import roy.coder.utils.algo.graph.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Dijkstra - The Shortest path algorithm in weighted graph.
 * Complexity: O(VlogV + E)
 */
public class Dijkstra extends FullPath {
    private static WeightedGraph g;
    public static List<Integer> distance;
    private static PriorityQueue<WeightedGraph.Vertex> pq;

    public static void run(WeightedGraph graph, int source) {
        g = graph;
        pq = new PriorityQueue<>();
        distance = new ArrayList<>();
        FullPath.init(g.adjacencyList.size());
        for (int i = 0, sz = g.adjacencyList.size(); i < sz; ++i) distance.add(Integer.MAX_VALUE);

        dijkstraUtil(source);
    }

    private static void dijkstraUtil(int source) {
        distance.set(source, 0);
        pq.add(WeightedGraph.Vertex.of(source, 0));

        visited.set(source, true);
        while (!pq.isEmpty()) {
            WeightedGraph.Vertex u = pq.poll();
            for (WeightedGraph.Vertex v : g.adjacencyList.get(u.node)) {
                if (distance.get(v.node) > distance.get(u.node) + v.cost) {
                    distance.set(v.node, distance.get(u.node) + v.cost);
                    pq.add(v);

                    visited.set(v.node, true);
                    parent.set(v.node, u.node);
                }
            }
        }
    }
}
