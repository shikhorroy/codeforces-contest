package roy.coder.utils.algo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of graph with adjacency list.
 * Nodes are zero-index based, e.g. if Graph initiated with n nodes,
 * nodes are 0, 1, 2, ..... n - 1.
 */
public class Graph {

    public enum Type {
        UNIDIRECTIONAL, BIDIRECTIONAL
    }

    protected Type type;
    public List<List<Integer>> adjacencyList;

    public void setType(Type type) {
        this.type = type;
    }

    public int getNodesCount() {
        return this.adjacencyList.size();
    }

    private void init(int nodes) {
        this.adjacencyList = new ArrayList<>();
        for (int node = 0; node < nodes; ++node) this.adjacencyList.add(new ArrayList<>());
    }

    public Graph(int nodes) {
        this.init(nodes);
        type = Type.BIDIRECTIONAL;
    }

    public Graph(int nodes, Type type) {
        this.init(nodes);
        this.type = type;
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList.get(source).add(destination);
        if (this.type.equals(Type.BIDIRECTIONAL)) this.adjacencyList.get(destination).add(source);
    }

    /**
     * Give the children of node.
     *
     * @param node asking for which children.
     * @return List of all child.
     */
    public List<Integer> childrenOf(int node) {
        if (node < this.getNodesCount()) return this.adjacencyList.get(node);
        throw new AssertionError("node out of bound");
    }
}
