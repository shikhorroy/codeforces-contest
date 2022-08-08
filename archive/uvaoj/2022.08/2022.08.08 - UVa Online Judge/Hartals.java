package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class Hartals {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int tCases = in.readInteger();
        for (int cs = 1; cs <= tCases; ++cs) {
            int n = in.readInteger();
            int p = in.readInteger();

            boolean[] isHortal = new boolean[n + 1];
            for (int i = 0; i < p; i++) {
                int h = in.readInteger();
                for (int j = h; j <= n; j += h) {
                    if (j % 7 != 6 && j % 7 != 0) isHortal[j] = true;
                }
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (isHortal[i]) ans++;
            }
            out.printLine(ans);
        }
    }
}
