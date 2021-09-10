package roy.coder.utils.algo.graph.shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FullPath {
    public static List<Integer> parent;
    public static List<Boolean> visited;

    public static void init(int nodes) {
        parent = new ArrayList<>();
        visited = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            parent.add(-1);
            visited.add(false);
        }
    }

    /**
     * Print path from source to any node destination vertex.
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
