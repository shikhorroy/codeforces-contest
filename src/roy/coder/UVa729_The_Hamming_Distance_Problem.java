package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class UVa729_The_Hamming_Distance_Problem {

    private StringBuilder ans;

    private void solve(int i, int oneCount, int n, int h, String string) {
        if (i == n) {
            if (oneCount == h) {
                if (ans.length() > 0) ans.append("\n");
                ans.append(string);
            }
            return;
        }

        solve(i + 1, oneCount, n, h, string + "0");
        if (oneCount < h) solve(i + 1, oneCount + 1, n, h, string + "1");
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int tCase = in.readInteger();

        for (int cs = 0; cs < tCase; cs++) {
            int n = in.readInteger();
            int h = in.readInteger();

            ans = new StringBuilder();
            this.solve(0, 0, n, h, "");

            if (cs > 0) out.printLine();
            out.printLine(ans);
        }
    }
}
