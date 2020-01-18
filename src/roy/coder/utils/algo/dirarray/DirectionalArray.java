package roy.coder.utils.algo.dirarray;

import java.util.HashMap;
import java.util.Map;

public class DirectionalArray {

    public enum Direction {
        FOUR, EIGHT, KNIGHT
    }

    private static final Map<Direction, Integer[][]> directionsArray = new HashMap<>();

    static {
        directionsArray.put(Direction.FOUR, new Integer[][]{{1, 0, -1, 0}, {0, 1, 0, -1}}); // 4 - directions
        directionsArray.put(Direction.EIGHT, new Integer[][]{{1, 1, 0, -1, -1, -1, 0, 1}, {0, 1, 1, 1, 0, -1, -1, -1}}); // 8 - directions
        directionsArray.put(Direction.KNIGHT, new Integer[][]{{2, 1, -1, -2, -2, -1, 1, 2}, {1, 2, 2, 1, -1, -2, -2, -1}}); // KNIGHT - directions
    }

    public static Integer[][] getDirections(Direction direction) {
        return directionsArray.get(direction);
    }
}
