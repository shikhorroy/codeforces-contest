package roy.coder;

import roy.coder.utils.algo.graph.AdjacencyMatrix;
import roy.coder.utils.algo.graph.Graph;
import roy.coder.utils.algo.graph.WeightedGraph;
import roy.coder.utils.algo.graph.shortestpath.Dijkstra;
import roy.coder.utils.algo.graph.shortestpath.FloydWarshall;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        testDijkstra();
        testFloydWarshall();
    }

    private static void testFloydWarshall() {
        AdjacencyMatrix m = getAdjacencyMatrix();
        FloydWarshall.run(m);
        System.out.println(Arrays.deepToString(FloydWarshall.matrix));
        System.out.println(FloydWarshall.getPath(3, 1));
    }

    private static AdjacencyMatrix getAdjacencyMatrix() {
        AdjacencyMatrix m = new AdjacencyMatrix(6);
        m.addEdge(0, 2, 2);
        m.addEdge(0, 4, 1);
        m.addEdge(0, 5, 4);
        m.addEdge(2, 3, 1);
        m.addEdge(2, 4, 2);
        m.addEdge(5, 4, 2);
        m.addEdge(1, 4, 7);
        m.addEdge(1, 5, 1);
        return m;
    }

    private static void testDijkstra() {
        //~ Dijkstra algo - weighted graph:
        WeightedGraph g = getWeightedGraph();
        Dijkstra.run(g, 1);
        System.out.println(Dijkstra.distance);
        Dijkstra.printPath(0);
    }

    private static WeightedGraph getWeightedGraph() {
        WeightedGraph g = new WeightedGraph(6);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(0, 5, 4);
        g.addEdge(2, 3, 1);
        g.addEdge(2, 4, 2);
        g.addEdge(5, 4, 2);
        g.addEdge(1, 4, 7);
        g.addEdge(1, 5, 1);
        return g;
    }

    private static Graph getGraph() {
        Graph g = new Graph(6);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(5, 4);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        return g;
    }
}
