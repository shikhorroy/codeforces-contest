package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class Prerequisites {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int n = in.readInteger();
            if (n == 0) return;
            int k = in.readInteger();

            Set<String> taken = new HashSet<>();
            for (int i = 0; i < n; i++) {
                taken.add(in.readString());
            }

            boolean isOk = true;
            for (int i = 0; i < k; i++) {
                int m = in.readInteger();
                int min = in.readInteger();

                int count = 0;
                for (int j = 0; j < m; j++) {
                    String course = in.readString();
                    if (taken.contains(course)) count++;
                }
                if (count < min) isOk = false;
            }

            if (isOk) out.printLine("yes");
            else out.printLine("no");
        }
    }
}
