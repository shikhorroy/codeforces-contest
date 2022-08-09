package roy.coder.utils.algo.ds.segtree;

import java.util.ArrayList;
import java.util.List;

public abstract class SegmentTree<T> {

    private final List<T> array;
    protected final List<T> tree;

    /**
     * Return value for an invalid range query.<br>
     * e.g. this should be zero(0) for range sum query, max infinity if range minimum query etc.
     */
    public abstract T invalidReturn();

    /**
     * Expected calculation for range query.<br>
     * e.g. this should - return (leftValue + rightValue) for range sum query,<br>
     * return Math.min(leftValue, rightValue) for range minimum query etc.
     *
     * @param leftValue  left subtree value.
     * @param rightValue right subtree value.
     * @return expected result after calculation.
     */
    public abstract T calculate(T leftValue, T rightValue);

    public void applyChange(T value, int currIndex) {
        tree.set(currIndex, value);
    }

    public SegmentTree(List<T> array) {
        this.array = array;
        tree = new ArrayList<>();
        for (int i = 0, sz = 4 * array.size() + 1; i < sz; i++) tree.add(null);

        this.buildTree(0, array.size() - 1, 1);
    }

    private void buildTree(int start, int end, int currIndex) {//~ O(n)
        if (start == end) {
            tree.set(currIndex, this.array.get(start));
        } else {
            int mid = (start + end) >> 1;
            buildTree(start, mid, left(currIndex));
            buildTree(mid + 1, end, right(currIndex));

            tree.set(currIndex, this.calculate(tree.get(left(currIndex)), tree.get(right(currIndex))));
        }
    }

    /**
     * Return expected result within range.
     *
     * @param start 0 based start index
     * @param end   0 base end index
     * @return expected query result
     */
    public T query(int start, int end) {
        return query(0, array.size() - 1, new Query(start, end), 1);
    }

    /**
     * Update index value.
     *
     * @param index zero(0) based index.
     * @param val   expected value to be updated.
     */
    public void update(int index, T val) {
        update(0, array.size() - 1, new Update(index, val), 1);
    }

    public void update(int start, int end, T val) {
        update(0, array.size() - 1, new RangeUpdate(start, end, val), 1);
    }

    private void update(int start, int end, Update update, int currIndex) {
        //~ index out of bound:
        if (end < update.index || update.index < start) return;

        if (start == end) applyChange(update.value, currIndex);
        else {
            int mid = (start + end) >> 1;
            update(start, mid, update, left(currIndex));
            update(mid + 1, end, update, right(currIndex));

            tree.set(currIndex, this.calculate(tree.get(left(currIndex)), tree.get(right(currIndex))));
        }
    }

    private void update(int start, int end, RangeUpdate update, int currIndex) {
        //~ index out of bound:
        if (end < update.start || update.end < start) return;

        if (start == end) applyChange(update.value, currIndex);
        else {
            int mid = (start + end) >> 1;
            update(start, mid, update, left(currIndex));
            update(mid + 1, end, update, right(currIndex));

            tree.set(currIndex, this.calculate(tree.get(left(currIndex)), tree.get(right(currIndex))));
        }
    }

    private T query(int start, int end, Query query, int currIndex) {// O(log n)
        //~ complete overlap: inside query range
        // query:    |2------------5|
        // case 01:  |   3------4   | start = 3, end = 4
        // case 02:  |2------------5| start = 2, end = 5
        if (query.start <= start && end <= query.end) return tree.get(currIndex);

        //~ no overlap: current segment outside query range
        // query:    |      3------------5         |
        // case 01:  |1---2                        | start = 1, end = 2
        // case 02:  |                      6-----8| start = 6, end = 8
        if (end < query.start || query.end < start) return this.invalidReturn();

        //~ partial overlap:
        // query:    |      3------------7    |
        // case 01:  |1-------4               | start = 1, end = 4
        // case 02:  |              5--------8| start = 5, end = 8
        int mid = (start + end) >> 1;
        T left = query(start, mid, query, left(currIndex));
        T right = query(mid + 1, end, query, right(currIndex));

        return calculate(left, right);
    }

    //~ utilities: start ~//
    private int left(int index) {
        return (index << 1);
    }

    private int right(int index) {
        return (index << 1) + 1;
    }

    private static class Query {
        int start;
        int end;

        Query(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private class Update {
        T value;
        int index;

        Update(int index, T value) {
            this.index = index;
            this.value = value;
        }
    }

    private class RangeUpdate {
        T value;
        int start, end;

        RangeUpdate(int start, int end, T value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    //~ utilities: end ~//
}
