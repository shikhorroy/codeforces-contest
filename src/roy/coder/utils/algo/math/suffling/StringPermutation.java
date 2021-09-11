package roy.coder.utils.algo.math.suffling;

import roy.coder.utils.utility.Swap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {

    private final char[] chars;
    private final Set<String> stringSet;
    private final List<String> stringList;

    public StringPermutation(String string) {
        chars = string.toCharArray();

        stringSet = new HashSet<>();
        stringList = new ArrayList<>();
    }

    /**
     * Generate all permutation list (duplicate elements may found).
     *
     * @return all possible permutation.
     */
    public StringPermutation permute() {
        if (this.count() == 0) this.permute(0, this.chars.length - 1);
        return this;
    }

    private void permute(int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            stringList.add(new String(chars));
        } else {
            for (int i = leftIndex; i <= rightIndex; i++) {
                chars[i] = Swap.between(chars[leftIndex], chars[leftIndex] = chars[i]);
                this.permute(leftIndex + 1, rightIndex);
                chars[i] = Swap.between(chars[leftIndex], chars[leftIndex] = chars[i]);
            }
        }
    }

    public StringPermutation unique() {
        if (this.countDistinct() == 0) {
            this.permute();
            this.stringSet.addAll(this.stringList);
        }
        return this;
    }

    public List<String> list() {
        this.permute();
        return this.stringList;
    }

    public Set<String> set() {
        this.unique();
        return this.stringSet;
    }

    public int count() {
        return this.stringList.size();
    }

    public int countDistinct() {
        return this.stringSet.size();
    }
}
