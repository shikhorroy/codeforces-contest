package roy.coder.utils.algo.dp.kadane;

import roy.coder.utils.utility.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KadaneOneD {

    public int maxSum;
    private final List<Integer> list;
    public List<Pair<Integer, Integer>> ranges;

    public KadaneOneD(List<Integer> list) {
        ranges = new ArrayList<>();
        this.list = list != null ? list : new ArrayList<>();

        run();
    }

    private void run() {
        int start = 0, end = 0;
        int currMaxSum = list.get(0), maxSumSoFar = list.get(0);

        Map<Integer, List<Pair<Integer, Integer>>> valueRanges = new HashMap<>();
        valueRanges.put(currMaxSum, new ArrayList<>());
        valueRanges.get(currMaxSum).add(Pair.of(start, end));

        for (int i = 1, sz = list.size(); i < sz; i++) {
            int currValue = list.get(i);
            int sum = currMaxSum + currValue;

            if (currValue > sum) {
                currMaxSum = currValue;
                start = end = i;
            } else {
                currMaxSum = sum;
                end = i;
            }

            if (currMaxSum >= maxSumSoFar) {
                maxSumSoFar = currMaxSum;
                if (!valueRanges.containsKey(maxSumSoFar)) valueRanges.put(maxSumSoFar, new ArrayList<>());
                valueRanges.get(maxSumSoFar).add(Pair.of(start, end));
            }
        }
        ranges = valueRanges.get(maxSumSoFar);
        maxSum = maxSumSoFar;
    }
}
