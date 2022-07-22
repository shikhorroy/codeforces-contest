package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheTowerOfBabylon {
    Integer[][] memo;
    List<Block> blockList;

    static class Block implements Comparable<Block> {
        int x, y, z;

        public Block(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Block o) {
            int c = Integer.compare(x, o.x);
            if (c == 0) {
                c = Integer.compare(y, o.y);
                if (c == 0) c = Integer.compare(z, o.z);
            }
            return c;
        }
    }

    int build(int n, int prev) {
        if (n == 0) return 0;
        if (memo[n][prev] != null) return memo[n][prev];

        Block curr = blockList.get(n - 1);
        Block last = blockList.get(prev);

        int ans = build(n - 1, prev);
        if (curr.x < last.x && curr.y < last.y) ans = Math.max(ans, curr.z + build(n - 1, n - 1));
        return memo[n][prev] = ans;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int n = in.readInteger();
            if (n == 0) return;

            blockList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = in.readInteger();
                int y = in.readInteger();
                int z = in.readInteger();

                if (x == y && y == z) blockList.add(new Block(x, y, z));
                else {
                    //~ possible combos:
                    //~ x y z
                    //~ x z y
                    //~ z x y
                    //~ z y x
                    //~ y z x
                    //~ y x z
                    //~ skips those entry if base not change:
                    blockList.add(new Block(x, y, z));
                    blockList.add(new Block(x, z, y));
                    if (x != z) blockList.add(new Block(z, x, y));
                    blockList.add(new Block(z, y, x));
                    if (z != y) blockList.add(new Block(y, z, x));
                    if (x != y) blockList.add(new Block(y, x, z));
                }
            }
            blockList.add(new Block(Integer.MAX_VALUE, Integer.MAX_VALUE, 0));
            Collections.sort(blockList);
            memo = new Integer[blockList.size() + 1][blockList.size()];
            int maxHeight = build(blockList.size(), blockList.size() - 1);
            out.printLine(String.format("Case %d: maximum height = %d", testNumber++, maxHeight));
        }
    }
}