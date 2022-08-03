package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class RequestForProposal {

    static class Info {
        int index;
        String name;
        double price;
        double compliance;

        public Info(int index, String name, double price, double compliance) {
            this.index = index;
            this.name = name;
            this.price = price;
            this.compliance = compliance;
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int n = in.readInteger();
            int p = in.readInteger();
            if (n == 0 && p == 0) return;

            for (int i = 0; i < n; i++) {
                in.readLine();// ignored
            }

            List<Info> infoList = new ArrayList<>();
            for (int i = 0; i < p; i++) {
                String proposal = in.readLine();
                double d = in.readDouble();
                int r = in.readInteger();
                infoList.add(new Info(i, proposal, d, (double) r / n));
                for (int j = 0; j < r; j++) in.readLine();// ignore
            }

            infoList.sort((o1, o2) -> {
                int c = Double.compare(o2.compliance, o1.compliance);
                if (c == 0) {
                    c = Double.compare(o1.price, o2.price);
                    if (c == 0) c = Integer.compare(o1.index, o2.index);
                }
                return c;
            });

            if (testNumber > 1) out.printLine();
            out.printLine("RFP #" + testNumber++ + "\n" + infoList.get(0).name);
        }
    }
}
//~ khubb baje problem description :(