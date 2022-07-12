package roy.coder.utils.algo.graph.tree;

import java.util.Arrays;
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

    private final int nodes;
    private final int powerOf2;

    private final Tree tree;
    private final int[] level;
    private final int[] parent;
    private final int[][] table;

    public LCA(Tree tree) {
        this.tree = tree;

        this.nodes = this.tree.getNodesCount();
        this.powerOf2 = this.calculateRequiredPowerOf2For(this.nodes);

        level = new int[nodes];
        parent = new int[nodes];
        table = new int[nodes][powerOf2];

        preProcessing();
    }

    /**
     * Calculate power(P) of 2 so that, 2^P >= n
     *
     * @param n boundary to calculate power
     * @return power of two required
     */
    private int calculateRequiredPowerOf2For(int n) {
        int power = 1;
        while ((1 << power) < n) power++;
        return power;
    }

    //~ Complexity: O(n x log(n))
    private void preProcessing() {
        parent[tree.root] = SENTINEL;//~ root doesn't have parent.
        dfs(tree.root);
        generateTables();
    }

    //~ finding the levels and parents of each node in the tree.
    private void dfs(int parent) {
        List<Integer> children = tree.childrenOf(parent);
        for (int child : children) {
            this.parent[child] = parent;
            level[child] = level[parent] + 1;

            dfs(child);
        }
    }

    private void generateTables() {
        for (int[] t : table) Arrays.fill(t, SENTINEL);
        for (int i = 0; i < this.nodes; i++)
            table[i][0] = parent[i];

        for (int p = 1; p < this.powerOf2; p++)
            for (int i = 0; i < this.nodes; i++)
                if (table[i][p - 1] != SENTINEL)
                    table[i][p] = table[table[i][p - 1]][p - 1];
    }

    /**
     * Complexity: O(log(n))
     */
    public int lcaBetween(int node1, int node2) {
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
}
