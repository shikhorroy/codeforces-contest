package roy.coder.utils.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ArrayUtility {

    private static <T> void safetyCheck(List<T> list) {
        Objects.requireNonNull(list);
        //~ if list is empty, then it can't be determined whether the list items are evens or odds.
        if (list.size() == 0) throw new RuntimeException("Provided list can't be empty");
    }

    public static <T> boolean areAllEvens(List<T> list) {
        safetyCheck(list);
        for (T value : list) if (MathUtility.isOdd(value)) return false;
        return true;
    }

    public static <T> boolean areAllOdds(List<T> list) {
        safetyCheck(list);
        for (T value : list) if (MathUtility.isEven(value)) return false;
        return true;
    }

    public static <T> int countEvens(List<T> list) {
        int evens = 0;
        for (T value : list) if (MathUtility.isEven(value)) ++evens;
        return evens;
    }

    public static <T> int countOdds(List<T> list) {
        int odds = 0;
        for (T value : list) if (MathUtility.isOdd(value)) ++odds;
        return odds;
    }

    /**
     * Count number frequency
     * Complexity: O(n), n = length of itemList.
     *
     * @param itemList list of items of type T.
     * @param <T>      of any type.
     * @return Map of item count.
     */
    public static <T> Map<T, Integer> countFrequency(List<T> itemList) {
        Map<T, Integer> frequency = new HashMap<>();
        for (T t : itemList) {
            if (!frequency.containsKey(t)) frequency.put(t, 0);
            frequency.put(t, frequency.get(t) + 1);
        }
        return frequency;
    }
}
