package roy.coder.utils.algo.graph.tree;

import java.util.Arrays;
import java.util.List;

/**
 * Lowest Common Ancestor (LCA) - using sparse table/binary lifting.
 * Complexity:
 * Preprocessing: O(n x log(n))
 * Query: O(log(n))
 */
public class LCA {

    private final Tree t;
    private final int[] level;
    private final int[] parent;
    private final int[][] table;

    public LCA(Tree t) {
        this.t = t;

        int nodes = this.t.getNodesCount();

        level = new int[nodes];
        parent = new int[nodes];
        table = new int[nodes][22];

        preprocessing();
    }

    //~ Complexity: O(n x log(n))
    private void preprocessing() {
        dfs(t.root);
        generateTables();
    }

    //~ finding the levels and parents of each node in the tree.
    private void dfs(int parent) {
        List<Integer> children = t.childrenOf(parent);
        for (int child : children) {
            this.parent[child] = parent;
            level[child] = level[parent] + 1;
            if (child == parent) continue;
            dfs(child);
        }
    }

    private void generateTables() {
        for (int[] t : table) Arrays.fill(t, -1);
        for (int i = 0, sz = t.getNodesCount(); i < sz; i++)
            table[i][0] = parent[i];

        for (int j = 1, sz = t.getNodesCount(); 1 << j < sz; j++)
            for (int i = 0; i < sz; i++)
                if (table[i][j - 1] != -1)
                    table[i][j] = table[table[i][j - 1]][j - 1];
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

        int log = 1;
        while (true) {
            int next = log + 1;
            if ((1 << next) > level[node1]) break;
            log++;
        }

        for (int i = log; i >= 0; i--)
            if (level[node1] - (1 << i) >= level[node2])
                node1 = table[node1][i];

        if (node1 == node2) return node1;

        for (int i = log; i >= 0; i--) {
            if (table[node1][i] != -1 && table[node1][i] != table[node2][i]) {
                node1 = table[node1][i];
                node2 = table[node2][i];
            }
        }

        return parent[node1];
    }
}
