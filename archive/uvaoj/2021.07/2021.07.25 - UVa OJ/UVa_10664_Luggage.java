package roy.coder;

import roy.coder.utils.algo.dp.zero_one_knapsack.SubsetSum;
import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class UVa_10664_Luggage {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int tc = in.readInteger();

        for (int cs = 0; cs < tc; cs++) {
            String[] items = in.readLine().split(" ");
            int sum = 0;
            List<Integer> weight = new ArrayList<>();
            for (String item : items) {
                int intVal = Integer.parseInt(item);
                weight.add(intVal);
                sum += intVal;
            }
            if (sum % 2 != 0) {
                out.printLine("NO");
                continue;
            }
            SubsetSum subsetSum = new SubsetSum(weight, sum / 2);
            if (subsetSum.iterativeDP()) out.printLine("YES");
            else out.printLine("NO");
        }
    }
}
