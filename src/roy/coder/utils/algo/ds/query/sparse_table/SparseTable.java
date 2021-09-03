package roy.coder.utils.algo.ds.query.sparse_table;

import roy.coder.utils.algo.ds.query.RangeQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Sparse table DS.
 * Complexity:
 * Processing - O(n x log(n))
 * Query- O(1)
 *
 * @param <T>
 */
public abstract class SparseTable<T> implements RangeQuery<T> {

    private final List<T> itemList;
    private final List<List<T>> table;

    /**
     * Prepare spares table.
     * Complexity: O(n x long(n))
     */
    private void init() {
        table.add(this.itemList);//~ o-the row in sparse table.
        for (int p = 1, sz = this.itemList.size(); (1 << p) < sz; ++p) {
            List<T> row = new ArrayList<>();
            for (int i = 0; i + (1 << p) <= sz; i++) {
                T first = this.table.get(p - 1).get(i);
                T second = this.table.get(p - 1).get(i + (1 << (p - 1)));
                row.add(compute(first, second));
            }
            table.add(row);
        }
    }

    public SparseTable(List<T> itemList) {
        this.itemList = itemList;
        table = new ArrayList<>();

        this.init();//~ prepare spare table.
    }

    @Override
    public T query(int l, int r) {
        //~ log2(x) = log(x) / log(2)
        int k = (int) (Math.log(r - l + 1) / Math.log(2));

        T value1 = this.table.get(k).get(l);
        T value2 = this.table.get(k).get(r - (1 << k) + 1);
        return this.compute(value1, value2);
    }
}
