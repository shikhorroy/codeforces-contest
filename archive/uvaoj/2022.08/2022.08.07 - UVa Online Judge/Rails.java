package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rails {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int n = in.readInteger();
            if (n == 0) return;

            List<Integer> original = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
            while (true) {
                int x = in.readInteger();
                if (x == 0) {
                    out.printLine();
                    break;
                }

                List<Integer> list = new ArrayList<>();
                list.add(x);
                for (int i = 1; i < n; i++) list.add(in.readInteger());

                boolean found = false;
                int index = 0, currOrigin = 0;
                Stack<Integer> stack = new Stack<>();
                while (index < n) {
                    found = false;
                    if (!stack.isEmpty() && Objects.equals(stack.peek(), list.get(index))) {
                        found = true;
                        stack.pop();
                        index++;
                    } else {
                        while (currOrigin < n && !Objects.equals(original.get(currOrigin), list.get(index))) {
                            stack.add(original.get(currOrigin++));
                        }
                        if (currOrigin < n && Objects.equals(original.get(currOrigin), list.get(index))) {
                            currOrigin++;
                            index++;
                            found = true;
                        }
                    }
                    if (!found) break;
                }

                if (!found) out.printLine("No");
                else out.printLine("Yes");
            }
        }
    }
}
