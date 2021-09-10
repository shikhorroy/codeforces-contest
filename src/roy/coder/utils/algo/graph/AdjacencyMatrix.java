package roy.coder.utils.algo.graph;

import java.security.InvalidParameterException;

public class AdjacencyMatrix {

    public enum Type {
        UNIDIRECTIONAL, BIDIRECTIONAL
    }

    public int nodes;
    protected Type type;
    public int[][] matrix;

    private void init(int nodes) {
        this.nodes = nodes;
        this.matrix = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i != j) this.matrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public AdjacencyMatrix(int nodes) {
        this.init(nodes);
        this.type = Type.BIDIRECTIONAL;
    }

    public AdjacencyMatrix(int nodes, Type type) {
        this.init(nodes);
        this.type = type;
    }

    public void addEdge(int source, int destination, int cost) {
        if (source >= nodes || destination >= nodes)
            throw new InvalidParameterException(source + " and " + destination + " should be < " + nodes);
        this.matrix[source][destination] = cost;
        if (this.type == Type.BIDIRECTIONAL) this.matrix[destination][source] = cost;
    }
}
