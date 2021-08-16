package roy.coder.utils.algo.ds.dsu;

import roy.coder.utils.utility.Swap;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetUnion {

    private List<Integer> link;
    private List<Integer> size;

    private void init(int nodes) {
        for (int i = 0; i < nodes; i++) {
            link.add(i);
            size.add(1);
        }
    }

    public DisjointSetUnion(int nodes) {
        link = new ArrayList<>();
        size = new ArrayList<>();
        this.init(nodes);
    }

    public int find(int node) {
        if (node == link.get(node)) return node;

        link.set(node, find(link.get(node)));
        return link.get(node);
    }

    public void union(int firstNode, int secondNode) {
        firstNode = find(firstNode);
        secondNode = find(secondNode);

        if (size.get(firstNode) < size.get(secondNode)) firstNode = Swap.between(secondNode, secondNode = firstNode);
        size.set(firstNode, size.get(firstNode) + size.get(secondNode));
        link.set(secondNode, firstNode);
    }

    public boolean sameParent(int firstNode, int secondNode) {
        return this.find(firstNode) == this.find(secondNode);
    }
}
