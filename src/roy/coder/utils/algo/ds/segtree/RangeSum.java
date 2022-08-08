package roy.coder.utils.algo.ds.segtree;

import java.util.List;

public class RangeSum extends SegmentTree {

    public RangeSum(List<Integer> array) {
        super(array);
    }

    @Override
    public int invalidReturn() {
        return 0;
    }

    @Override
    public int calculate(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }
}
