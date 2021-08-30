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

    /**
     * Find max values among integer or long values.
     *
     * @param values - among where max value need to find.
     * @param <T>    - should be of integer or long.
     * @return maximum among values.
     */
    public static <T extends Number> T max(T... values) {
        T max = values[0];
        for (int i = 1; i < values.length; i++)
            if (values[i].longValue() > max.longValue()) max = values[i];
        return max;
    }

    /**
     * Find min values among integer or long values.
     *
     * @param values - among where min value need to find.
     * @param <T>    - should be of integer or long.
     * @return minimum among values.
     */
    public static <T extends Number> T min(T... values) {
        T min = values[0];
        for (int i = 1; i < values.length; i++)
            if (values[i].longValue() < min.longValue()) min = values[i];
        return min;
    }
}
