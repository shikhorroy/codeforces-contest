package roy.coder.utils.algo.ds.query.sparse_table;

import java.math.BigDecimal;
import java.util.List;

public class SUMSparseTable<T extends Number> extends SparseTable<T> {

    public SUMSparseTable(List<T> itemList) {
        super(itemList);
    }

    @Override
    public T compute(T elem1, T elem2) {
        if (elem1 instanceof Integer) return (T) Integer.valueOf(elem1.intValue() + elem2.intValue());
        if (elem1 instanceof Long) return (T) Long.valueOf(elem1.longValue() + elem2.longValue());
        return (T) Double.valueOf(elem1.doubleValue() + elem2.doubleValue());
    }

    @Override
    public T query(int l, int r) {
        BigDecimal answer = BigDecimal.ZERO;
        for (int k = (int) (Math.log(r - l + 1) / Math.log(2)); k >= 0; k--) {
            if (l + (1 << k) - 1 <= r) {
                answer = answer.add(
                        new BigDecimal(this.table.get(k).get(l).toString())
                );
                l += 1 << k;
            }
        }
        if (this.itemList.get(0) instanceof Integer) return (T) Integer.valueOf(answer.intValue());
        if (this.itemList.get(0) instanceof Long) return (T) Long.valueOf(answer.longValue());
        return (T) Double.valueOf(answer.doubleValue());
    }
}
