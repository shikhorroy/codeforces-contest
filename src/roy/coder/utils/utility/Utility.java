package roy.coder.utils.utility;

public class Utility {

    /**
     * Check if all values are same.
     *
     * @param values - values for checking equality
     * @param <T>    - of any type
     * @return true if all elements are equal, false otherwise.
     */
    public static <T> boolean allEquals(T... values) {
        for (int i = 1; i < values.length; i++) if (!values[i].equals(values[i - 1])) return false;
        return true;
    }
}
