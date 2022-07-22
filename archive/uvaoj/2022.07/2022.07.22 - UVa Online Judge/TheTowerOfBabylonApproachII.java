package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TheTowerOfBabylonApproachII {
    Integer[] memo;
    List<Block> blockList;

    static class Block {
        int x, y, z;

        public Block(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    int build(int n) {
        if (memo[n] != null) return memo[n];

        int ans = 0;
        Block currTop = blockList.get(n);
        for (int i = 0, sz = blockList.size(); i < sz; i++) {
            Block choice = blockList.get(i);
            if (choice.x < currTop.x && choice.y < currTop.y) {
                ans = Math.max(ans, choice.z + build(i));
            }
        }
        return memo[n] = ans;
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
                    blockList.add(new Block(x, y, z));
                    blockList.add(new Block(x, z, y));
                    blockList.add(new Block(z, x, y));
                    blockList.add(new Block(z, y, x));
                    blockList.add(new Block(y, z, x));
                    blockList.add(new Block(y, x, z));
                }
            }
            blockList.add(new Block(Integer.MAX_VALUE, Integer.MAX_VALUE, 0));
            memo = new Integer[blockList.size()];
            int maxHeight = build(blockList.size() - 1);
            out.printLine(String.format("Case %d: maximum height = %d", testNumber++, maxHeight));
        }
    }
}
