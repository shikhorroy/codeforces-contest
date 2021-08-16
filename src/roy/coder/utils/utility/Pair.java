package roy.coder.utils.utility;

import java.util.Objects;

public class Pair<F, S> implements Comparable<Pair<F, S>> {

    public F first;
    public S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <K, V> Pair<K, V> of(K first, V second) {
        return new Pair<K, V>(first, second);
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
        if (o instanceof Pair) {
            Pair<F, S> pair = (Pair<F, S>) o;
            if (!Objects.equals(first, pair.first)) return false;
            return Objects.equals(second, pair.second);
        }
        return false;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.second.hashCode(), o.second.hashCode());
    }
}
