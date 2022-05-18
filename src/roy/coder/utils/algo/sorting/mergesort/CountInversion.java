package roy.coder.utils.algo.sorting.mergesort;

import java.util.ArrayList;
import java.util.List;

/***
 * Inversion Count of an Array:
 * Given an array, find the total number of inversions of it. If (i < j) and (A[i] >= A[j]), then pair (i, j) is called
 * an inversion of an array A. We need to count all such pairs in the array.
 *
 * For example,
 * Input:  A = [1, 9, 6, 4, 5, 9]
 * Output: The inversion count is: 6
 * Inversions are: (9, 6), (9, 4), (9, 5), (9, 9), (6, 4), (6, 5)
 *
 * Complexity: O(nlogn)
 * Source: Modified version of - https://www.topcoder.com/thrive/articles/count-inversions-in-an-array
 */

public class CountInversion {

    public static <T extends Comparable<T>> long run(List<T> elems) {
        if (elems == null) elems = new ArrayList<>();
        return enhMergeCountInv(elems, 0, elems.size() - 1);
    }

    private static <T extends Comparable<T>> long enhMergeCountInv(List<T> elems, int left, int right) {
        long countInv = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            countInv += enhMergeCountInv(elems, left, mid);
            countInv += enhMergeCountInv(elems, mid + 1, right);
            countInv += mergeArrayCountInv(elems, left, mid, right);
        }
        return countInv;
    }

    private static <T extends Comparable<T>> long mergeArrayCountInv(List<T> elems, int ll, int mm, int rr) {
        List<T> left = new ArrayList<>(elems.subList(ll, mm + 1));
        List<T> right = new ArrayList<>(elems.subList(mm + 1, rr + 1));

        long swaps = 0;
        int ii = 0, jj = 0, kk = ll;
        while (ii < left.size() && jj < right.size()) {
            if (left.get(ii).compareTo(right.get(jj)) >= 0) {//~ check if (A[i] >= A[j]) then count
                elems.set(kk++, right.get(jj++));
                swaps += (mm + 1) - (ll + ii);
            } else elems.set(kk++, left.get(ii++));
        }
        while (ii < left.size())
            elems.set(kk++, left.get(ii++));
        while (jj < right.size())
            elems.set(kk++, right.get(jj++));
        return swaps;
    }
}
