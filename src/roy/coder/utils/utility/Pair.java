package roy.coder.utils.utility;

public class Pair<K, V> implements Comparable<Pair> {

    public K key;

    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <K, V> Pair of(K key, V value) {
        return new Pair(key, value);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (key != null ? key.hashCode() : 0);
        hash = 31 * hash + (value != null ? value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
            if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
            if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Pair o) {
        return (this.key.hashCode() < o.key.hashCode()) ? -1 :
                (this.key.hashCode() > o.key.hashCode()) ? 1 :
                        (this.value.hashCode() < o.value.hashCode()) ? -1 :
                                (this.value.hashCode() > o.value.hashCode()) ? 1 : 0;
    }
}
