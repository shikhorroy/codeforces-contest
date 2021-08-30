package roy.coder.utils.utility;

import java.util.List;
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
}
