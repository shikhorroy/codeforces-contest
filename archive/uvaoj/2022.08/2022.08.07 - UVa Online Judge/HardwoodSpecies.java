package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.Map;
import java.util.TreeMap;

public class HardwoodSpecies {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int tCases = in.readInteger();
        in.read();// newline
        for (int cs = 1; cs <= tCases; ++cs) {
            if (cs > 1) out.printLine();

            Map<String, Integer> frequency = new TreeMap<>();
            while (true) {
                String tree = null;
                try {
                    tree = in.readLine();//~ need to update readLine method:
                    // public String readLine() {
                    //    int c = read();
                    //    if (c == '\n') return "\n";
                    //    StringBuilder res = new StringBuilder();
                    //    do {
                    //        res.appendCodePoint(c);
                    //        c = read();
                    //    } while (!isNewlineChar(c));
                    //    return res.toString();
                    // }
                } catch (Exception ignored) {
                }
                if (tree == null || tree.equals("\n")) break;
                frequency.put(tree, frequency.getOrDefault(tree, 0) + 1);
            }
            int total = 0;
            for (Integer count : frequency.values()) {
                total += count;
            }

            for (String tree : frequency.keySet()) {
                out.printLine(String.format("%s %.4f", tree, (100.0 * frequency.get(tree) / total)));
            }
        }
    }
}
