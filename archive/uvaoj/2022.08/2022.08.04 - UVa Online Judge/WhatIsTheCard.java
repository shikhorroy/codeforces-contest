package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class WhatIsTheCard {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int tCases = in.readInteger();
        for (int cs = 1; cs <= tCases; ++cs) {
            List<String> cards = new ArrayList<>();
            for (int i = 0; i < 52; i++) {
                cards.add(in.readString());
            }

            List<String> top25 = new ArrayList<>(cards.subList(52 - 25, 52));
            cards = cards.subList(0, 52 - 25);

            int y = 0;
            for (int repeat = 0; repeat < 3; repeat++) {
                int sz = cards.size();
                String topCard = cards.get(sz - 1);
                int value = (Character.isDigit(topCard.charAt(0))) ? topCard.charAt(0) - '0' : 10;
                y += value;
                cards.remove(sz - 1);
                sz = cards.size();
                cards = cards.subList(0, sz - (10 - value));
            }
            List<String> newList = new ArrayList<>(cards);
            newList.addAll(top25);
            out.printLine(String.format("Case %d: %s", testNumber++, newList.get(y - 1)));
        }
    }
}
