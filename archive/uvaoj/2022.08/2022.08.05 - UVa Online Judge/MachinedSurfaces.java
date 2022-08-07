package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class MachinedSurfaces {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int n = in.readInteger();
            if (n == 0) return;

            int max = 0;
            List<Integer> count = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = in.readLine();
                int c = 0;
                for (int j = 0, ln = s.length(); j < ln; j++) {
                    if (s.charAt(j) == 'X') c++;
                }
                max = Math.max(max, c);
                count.add(c);
            }
            int ans = 0;
            for (int c : count) {
                ans += max - c;
            }
            out.printLine(ans);
        }
    }
}
