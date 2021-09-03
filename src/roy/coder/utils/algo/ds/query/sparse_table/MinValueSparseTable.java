package roy.coder.utils.algo.ds.query.sparse_table;

import java.util.List;

public class MinValueSparseTable<T extends Comparable<T>> extends SparseTable<T> {

    public MinValueSparseTable(List<T> itemList) {
        super(itemList);
    }

    @Override
    public T compute(T elem1, T elem2) {
        if (elem1.compareTo(elem2) < 0) return elem1;
        return elem2;
    }
}
