package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class BurgerTime {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int l = in.readInteger();
            if (l == 0) return;

            int ans = Integer.MAX_VALUE, r = -1, d = -1;
            String s = in.readString();
            for (int i = 0, ln = s.length(); i < ln; i++) {
                char c = s.charAt(i);
                if (c == 'R') r = i;
                else if (c == 'D') d = i;
                else if (c == 'Z') r = d = i;

                if (r > -1 && d > -1) {
                    ans = Math.min(ans, Math.abs(r - d));
                }
            }

            out.printLine(ans);
        }
    }
}
