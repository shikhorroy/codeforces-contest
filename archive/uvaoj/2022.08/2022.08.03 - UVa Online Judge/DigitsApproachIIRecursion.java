package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class DigitsApproachIIRecursion {

    int solve(String num) {
        if (num.equals("1")) return 1;
        return 1 + solve("" + num.length());
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            String prev = in.readString();
            if (prev.equalsIgnoreCase("end")) return;
            out.printLine(solve(prev));
        }
    }
}
