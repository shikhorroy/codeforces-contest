package roy.coder.utils.algo.graph;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class WeightedGraph extends Graph {

    public static class Vertex implements Comparable<Vertex> {
        public int node;
        public int cost;

        private Vertex(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public static Vertex of(int node, int cost) {
            return new Vertex(node, cost);
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public List<List<Vertex>> adjacencyList;

    private void init(int nodes) {
        this.adjacencyList = new ArrayList<>();
        for (int node = 0; node < nodes; ++node) this.adjacencyList.add(new ArrayList<>());
    }

    public WeightedGraph(int nodes) {
        super(nodes);
        init(nodes);
    }

    public WeightedGraph(int nodes, Type type) {
        super(nodes, type);
        init(nodes);
    }

    public void addEdge(int source, int destination, int cost) {
        int nodeCount = this.getNodesCount();
        if (destination >= nodeCount)
            throw new InvalidParameterException("Destination: " + destination + " should be < " + nodeCount);
        this.adjacencyList.get(source).add(Vertex.of(destination, cost));
        if (this.type.equals(Type.BIDIRECTIONAL)) this.adjacencyList.get(destination).add(Vertex.of(source, cost));
    }
}
