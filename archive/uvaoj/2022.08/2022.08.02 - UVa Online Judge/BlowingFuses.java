package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class BlowingFuses {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int n = in.readInteger();
            int m = in.readInteger();
            int c = in.readInteger();
            if (n == 0 && m == 0 && c == 0) return;

            boolean[] state = new boolean[n];
            int[] cap = new int[n];
            boolean blown = false;
            int consumption = 0, maxConsumption = 0;
            for (int i = 0; i < n; i++) cap[i] = in.readInteger();
            for (int i = 0; i < m; i++) {
                int which = in.readInteger();
                if (blown) continue;

                if (state[which - 1]) {
                    state[which - 1] = false;
                    consumption -= cap[which - 1];
                } else {
                    state[which - 1] = true;
                    consumption += cap[which - 1];
                }

                maxConsumption = Math.max(maxConsumption, consumption);
                if (maxConsumption > c) blown = true;
            }
            out.printLine("Sequence " + testNumber++);
            if (blown) out.printLine("Fuse was blown.\n");
            else out.printLine("Fuse was not blown.\nMaximal power consumption was " + maxConsumption + " amperes.\n");
        }
    }
}
