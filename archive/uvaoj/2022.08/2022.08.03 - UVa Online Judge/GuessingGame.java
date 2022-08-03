package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class GuessingGame {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            boolean isCheat = false;
            int first = 1, last = 10;
            while (true) {
                int guess = in.readInteger();
                if (guess == 0) return;
                String response = in.readLine();

                if (response.equals("right on")) {
                    if (guess >= first && guess <= last) ;
                    else isCheat = true;
                    break;
                } else {
                    if (guess > last || guess < first) {
                        if (guess > last && !response.equals("too high")
                                || guess < last && !response.equals("too low"))
                            isCheat = true;
                        continue;
                    }

                    if (response.equals("too high")) {
                        last = guess - 1;
                        if (last < first) isCheat = true;
                    } else if (response.equals("too low")) {
                        first = guess + 1;
                        if (first > last) isCheat = true;
                    }
                }
            }
            if (isCheat) out.printLine("Stan is dishonest");
            else out.printLine("Stan may be honest");
        }
    }
}
