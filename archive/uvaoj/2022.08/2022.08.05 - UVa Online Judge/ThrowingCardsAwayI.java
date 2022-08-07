package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ThrowingCardsAwayI {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int n = in.readInteger();
            if (n == 0) return;

            Deque<Integer> d = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                d.add(i);
            }

            List<Integer> thrown = new ArrayList<>();
            while (d.size() != 1) {
                thrown.add(d.pollFirst());
                int nowTop = d.pollFirst();
                d.add(nowTop);
            }

            out.print("Discarded cards:");
            for (int i = 0, sz = thrown.size(); i < sz; i++) {
                if (i != 0) out.print(",");
                out.print(" " + thrown.get(i));
            }
            out.printLine("\nRemaining card: " + d.peek());
        }
    }
}
