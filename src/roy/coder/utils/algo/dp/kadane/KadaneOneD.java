package roy.coder.utils.algo.dp.kadane;

import roy.coder.utils.utility.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Algorithm - Kadane's algorithm: Find the max sub-array sum of one dimensional array.
 * <p>
 * Complexity: O(n)
 */
public class KadaneOneD<T extends Number & Comparable<T>> {

    public T maxSum;
    private final List<T> list;

    public List<Pair<Integer, Integer>> ranges;

    public KadaneOneD(List<T> list) {
        ranges = new ArrayList<>();
        maxSum = (T) Integer.valueOf(0);
        this.list = list != null ? list : new ArrayList<>();
    }

    public T run() {
        if (list.size() == 0) return (T) Integer.valueOf(0);

        int start = 1, end = 1;
        T currMaxSum = list.get(0), maxSumSoFar = list.get(0);

        Map<T, List<Pair<Integer, Integer>>> valueRanges = new HashMap<>();
        valueRanges.put(currMaxSum, new ArrayList<>());
        valueRanges.get(currMaxSum).add(Pair.of(start, end));

        for (int i = 1, sz = list.size(); i < sz; i++) {
            T currValue = list.get(i);
            T sum = this.sum(currMaxSum, currValue);

            if (currValue.compareTo(sum) > 0) {
                currMaxSum = currValue;
                start = end = i + 1;
            } else {
                currMaxSum = sum;
                end = i + 1;
            }

            if (currMaxSum.compareTo(maxSumSoFar) >= 0) {
                maxSumSoFar = currMaxSum;
                if (!valueRanges.containsKey(maxSumSoFar)) valueRanges.put(maxSumSoFar, new ArrayList<>());
                valueRanges.get(maxSumSoFar).add(Pair.of(start, end));
            }
        }
        ranges = valueRanges.get(maxSumSoFar);
        return maxSum = maxSumSoFar;
    }

    private T sum(T x, T y) {
        if (x instanceof Integer) return (T) Integer.valueOf(x.intValue() + y.intValue());
        if (x instanceof Long) return (T) Long.valueOf(x.longValue() + y.longValue());
        return (T) Double.valueOf(x.doubleValue() + y.doubleValue());
    }
}
