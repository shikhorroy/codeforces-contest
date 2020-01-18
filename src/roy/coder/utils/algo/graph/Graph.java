package roy.coder.utils.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public enum Type {
        UNIDIRECTIONAL, BIDIRECTIONAL
    }

    private int nodes;
    public List<Integer> adjacencyList[];
    private Type type = Type.BIDIRECTIONAL;

    public void setType(Type type) {
        this.type = type;
    }

    public Graph(int nodes) {
        this.nodes = nodes;

        this.adjacencyList = new List[nodes];
        for (int node = 0; node < nodes; ++node) {
            this.adjacencyList[node] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
        if (this.type.equals(Type.BIDIRECTIONAL)) {
            this.adjacencyList[destination].add(source);
        }
    }
}
