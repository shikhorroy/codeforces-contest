package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class LaserSculpture {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int a = in.readInteger();
            if (a == 0) return;
            int c = in.readInteger();

            int ans = 0;
            int maxHeight = in.readInteger();
            int prevHeight = maxHeight;
            for (int i = 1; i < c; i++) {
                int currHeight = in.readInteger();
                if (prevHeight >= currHeight) ans += prevHeight - currHeight;
                else if (currHeight > maxHeight) {
                    ans += currHeight - maxHeight;
                    maxHeight = currHeight;
                }
                prevHeight = currHeight;
            }

            ans += a - maxHeight;
            out.printLine(ans);
        }
    }
}
