package roy.coder.utils.algo.graph.tree;

import java.util.List;

/**
 * Lowest Common Ancestor (LCA) - using sparse table / binary lifting.<br><br>
 * <b>Complexity:</b><br>
 * Preprocessing: O(n x log(n))<br>
 * Query: O(log(n))<br>
 * Source: <a href="http://www.shafaetsplanet.com/?p=1831"> Safayet Plant</a>
 */
public class LCA {
    private final int SENTINEL = -1;

    private final int powerOf2;

    private final Tree tree;
    private final int[] level;
    private final int[] parent;

    /**
     * <code>table[currNode][i]</code> - indicates <code>2<sup>i</sup>-th</code> node
     * above from <code>currNode</code>.
     */
    private final int[][] table;

    public LCA(Tree tree) {
        this.tree = tree;

        int nodes = this.tree.getNodesCount();
        this.powerOf2 = this.calculateRequiredPowerOf2For(nodes);

        level = new int[nodes];
        parent = new int[nodes];
        table = new int[nodes][powerOf2];

        parent[tree.root] = SENTINEL;
        binaryLifting(tree.root);
    }

    private int calculateRequiredPowerOf2For(int n) {
        int power = 1;
        while ((1 << power) <= n) power++;
        return power;
    }

    /**
     * DFS recursive function to populate level, parent and sparse table.
     *
     * @param currNode current node from where child nodes will be traversed.
     */
    private void binaryLifting(int currNode) {
        List<Integer> children = tree.childrenOf(currNode);
        for (int child : children) {
            level[child] = level[currNode] + 1;
            //~ table[child][0] - indicates 2^0=1 level up node from child node,
            //~ i.e. the parent node.
            table[child][0] = this.parent[child] = currNode;

            for (int p = 1; p < this.powerOf2; p++) {
                if (table[child][p - 1] != SENTINEL) {
                    table[child][p] = table[table[child][p - 1]][p - 1];
                } else {
                    table[child][p] = SENTINEL;
                }
            }

            binaryLifting(child);
        }
    }

    public int findLCA(int node1, int node2) {
        if (level[node1] < level[node2]) {
            int tmp = node1;
            node1 = node2;
            node2 = tmp;
        }

        int log = this.calculateRequiredPowerOf2For(level[node1]);
        for (int i = log; i >= 0; i--)
            if (level[node1] - (1 << i) >= level[node2])
                node1 = table[node1][i];

        if (node1 == node2) return node1;

        for (int i = log; i >= 0; i--) {
            if (table[node1][i] != SENTINEL && table[node1][i] != table[node2][i]) {
                node1 = table[node1][i];
                node2 = table[node2][i];
            }
        }

        return parent[node1];
    }

    public int kthAncestor(int node, int k) {
        if (k > level[node]) return SENTINEL;

        int log = this.calculateRequiredPowerOf2For(k) + 1;
        while (--log >= 0) if (((1 << log) & k) > 0) node = table[node][log];
        return node;
    }
}
