package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.*;

public class ClockPatience {
    // Disclaimer:
// one of the Faltuest problem input I have ever seen:
//    input:
//    TS QC 8S 8D QH 2D 3H KH 9H 2H TH KS KC
//    9D JH 7H JD 2S QS TD 2C 4H 5H AD 4D 5D
//    6D 4S 9S 5S 7S JS 8H 3D 8C 3S 4C 6S 9C
//    AS 7C AH 6H KD JC 7D AC 5C TC QD 6C 3C
// Mappings:
//         A     2   ....... k
// 0 ->    3C    6C  ....... AS
// 2 ->    9C    6S  ....... 6D
// 3 ->    5D    4D  ....... 9D
// 4 ->    KC    KS  ....... TS
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            List<String> line = Arrays.asList(in.readLine().split(" "));
            if (line.get(0).equals("#")) return;

            List<List<String>> cards = new ArrayList<>();
            cards.add(line);

            Map<Character, Stack<String>> trace = new LinkedHashMap<>();
            trace.put('K', new Stack<>());
            trace.put('Q', new Stack<>());
            trace.put('J', new Stack<>());
            trace.put('T', new Stack<>());
            trace.put('9', new Stack<>());
            trace.put('8', new Stack<>());
            trace.put('7', new Stack<>());
            trace.put('6', new Stack<>());
            trace.put('5', new Stack<>());
            trace.put('4', new Stack<>());
            trace.put('3', new Stack<>());
            trace.put('2', new Stack<>());
            trace.put('A', new Stack<>());

            for (int j = 0; j < 3; j++) {
                cards.add(Arrays.asList(in.readLine().split(" ")));
            }

            for (int i = cards.size() - 1; i >= 0; i--) {
                line = cards.get(i);
                int j = 0;
                for (char c : trace.keySet()) {
                    trace.get(c).add(line.get(j++));
                }
            }

            int flipped = 0;
            char curr = 'K';
            String top = null;
            while (!trace.get(curr).isEmpty()) {
                top = trace.get(curr).pop();
                curr = top.charAt(0);
                flipped++;
            }

            out.printLine(String.format("%02d,%s", flipped, top));
        }
    }
}
