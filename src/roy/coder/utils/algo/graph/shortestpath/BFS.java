package roy.coder.utils.algo.graph.shortestpath;

import roy.coder.utils.algo.graph.Graph;

import java.util.*;

public class BFS {

    private static Graph g;
    private static Queue<Integer> q;
    public static List<Integer> parent;
    public static List<Boolean> visited;
    public static List<Integer> distance;

    public static void run(Graph graph, int source) {
        g = graph;
        q = new LinkedList<>();
        parent = new ArrayList<>();
        visited = new ArrayList<>();
        distance = new ArrayList<>();
        for (int i = 0, sz = g.adjacencyList.size(); i < sz; ++i) {
            parent.add(-1);
            distance.add(0);
            visited.add(false);
        }

        bfsUtil(source);
    }

    private static void bfsUtil(int s) {
        q.add(s);
        visited.set(s, true);
        while (!q.isEmpty()) {
            int v = q.peek();
            q.remove();
            List<Integer> adjacencyList = g.adjacencyList.get(v);
            for (int u : adjacencyList) {
                if (!visited.get(u)) {
                    q.add(u);
                    parent.set(u, v);
                    visited.set(u, true);
                    distance.set(u, distance.get(v) + 1);
                }
            }
        }
    }

    /**
     * Print path from source to any node destinationNode
     *
     * @param destination destination node from source
     */
    public static void printPathFrom(int destination) {
        if (!visited.get(destination)) {
            System.out.println("No path!");
        } else {
            List<Integer> path = new ArrayList<>();
            for (int v = destination; v != -1; v = parent.get(v)) path.add(v);
            Collections.reverse(path);
            System.out.print("Path: ");
            for (int i = 0; i < path.size(); i++) {
                if (i != 0) System.out.print(" -> ");
                System.out.print(path.get(i));
            }
        }
    }
}
