package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class Bingo {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int n = in.readInteger();
            int b = in.readInteger();
            if (n == 0 && b == 0) return;

            int[] balls = new int[b];
            boolean[] possible = new boolean[n + 1];
            for (int i = 0; i < b; i++) {
                int ball = in.readInteger();
                balls[i] = ball;
                possible[ball] = true;
            }
            int possibleCount = 0;
            for (int target = 0; target <= n; target++) {
                int prevCounts = possibleCount;
                for (int i = 0; i < b; i++) {// |ball1 - ball2| = target
                    int ball1 = balls[i];
                    int ball2 = target + ball1;
                    if (ball2 <= n && possible[ball1] && possible[ball2]) {
                        possibleCount++;
                        break;// if found then terminate loop otherwise count will be increased
                    }
                }
                if (prevCounts == possibleCount) break;// we can not make target.
            }

            if (possibleCount == n + 1) out.printLine("Y");
            else out.printLine("N");
        }
    }
}
