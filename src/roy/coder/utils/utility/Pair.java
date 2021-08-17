package roy.coder.utils.utility;

import java.util.Objects;

public class Pair<F, S> implements Comparable<Pair<F, S>> {

    public F first;
    public S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <F, S> Pair<F, S> of(F first, S second) {
        return new Pair<>(first, second);
    }

    @Override
    public String toString() {
        return "<" + first + ", " + second + ">";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (first != null ? first.hashCode() : 0);
        hash = 31 * hash + (second != null ? second.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair<?, ?>) {
            Pair<?, ?> pair = (Pair<?, ?>) o;
            if (!Objects.equals(first, pair.first)) return false;
            return Objects.equals(second, pair.second);
        }
        return false;
    }

    @Override
    public int compareTo(Pair o) {
        int comparedVal = Integer.compare(this.first.hashCode(), o.first.hashCode());
        if (comparedVal == 0) return Integer.compare(this.second.hashCode(), o.second.hashCode());
        return comparedVal;
    }
}
