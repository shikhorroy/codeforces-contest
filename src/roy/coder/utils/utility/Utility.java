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

    /**
     * Check if any values matched to target.
     *
     * @param target - need to matched with.
     * @param values - among which target need to check.
     * @param <T>    - any type.
     * @return true if match found, false otherwise.
     */
    public static <T> boolean anyEqual(T target, T... values) {
        for (T value : values) if (value.equals(target)) return true;
        return false;
    }
}
