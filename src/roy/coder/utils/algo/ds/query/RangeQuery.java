package roy.coder.utils.algo.ds.query;

/**
 * Range minimum query.
 *
 * @param <T> - of any type.
 */
public interface RangeQuery<T> {

    /**
     * Query from l-index to r-index
     *
     * @param l - left index
     * @param r - right index
     * @return a value based on compute()
     */
    T query(int l, int r);

    /**
     * Required computation for range query. e.g. min, max, gcd, lcm, sum etc.
     *
     * @param elem1 - first element
     * @param elem2 - second element
     * @return required computation value.
     */
    T compute(T elem1, T elem2);
}
