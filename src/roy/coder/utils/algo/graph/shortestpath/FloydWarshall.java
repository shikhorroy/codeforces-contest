package roy.coder.utils.algo.graph.shortestpath;

import roy.coder.utils.algo.graph.AdjacencyMatrix;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {

    public static int nodes;
    public static int[][] next;
    public static int[][] matrix;

    public static void run(AdjacencyMatrix adjacencyMatrix) {
        nodes = adjacencyMatrix.nodes;
        matrix = adjacencyMatrix.matrix;

        next = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) next[i][j] = -1;
                else next[i][j] = j;
            }
        }

        floydWarshallUtil();
    }

    private static void floydWarshallUtil() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) continue;
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public static long getMinCosts(int source, int destination) {
        if (source >= nodes || destination >= nodes)
            throw new InvalidParameterException(source + " and " + destination + " should be < " + nodes);

        return matrix[source][destination];
    }

    public static List<Integer> getPath(int source, int destination) {
        if (next[source][destination] == -1) return null;

        List<Integer> path = new ArrayList<>();
        path.add(source);

        while (source != destination) {
            source = next[source][destination];
            path.add(source);
        }
        return path;
    }
}
