package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class Digits {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            String prev = in.readString();
            if (prev.equalsIgnoreCase("end")) return;

            int i = 0;
            while (true) {
                i++;
                String curr = prev.length() + "";
                if (curr.equals(prev)) {
                    out.printLine(i);
                    break;
                }
                prev = curr;
            }
        }
    }
}
