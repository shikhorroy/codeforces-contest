package roy.coder.utils.algo.graph.tree;

import roy.coder.utils.algo.graph.Graph;

public class Tree extends Graph {

    public Integer root;

    public Tree(int nodes, int root) {
        super(nodes, Type.UNIDIRECTIONAL);
        this.root = root;
    }
}
