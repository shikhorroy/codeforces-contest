package roy.coder.utils.algo.ds.query.sparse_table;

import roy.coder.utils.algo.math.LCM;

import java.util.List;

public class LCMSparseTable<T extends Number> extends SparseTable<T> {

    public LCMSparseTable(List<T> itemList) {
        super(itemList);
    }

    @Override
    public T compute(T elem1, T elem2) {
        return LCM.of(elem1, elem2);
    }
}
