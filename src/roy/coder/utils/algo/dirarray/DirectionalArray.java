package roy.coder.utils.algo.dirarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectionalArray {
    private static final Map<Direction, Integer[][]> directionsArray = new HashMap<>();

    static {
        directionsArray.put(Direction.FOUR, new Integer[][]{{1, 0, -1, 0}, {0, 1, 0, -1}}); // 4 - directions
        directionsArray.put(Direction.EIGHT, new Integer[][]{{1, 1, 0, -1, -1, -1, 0, 1}, {0, 1, 1, 1, 0, -1, -1, -1}}); // 8 - directions
        directionsArray.put(Direction.KNIGHT, new Integer[][]{{2, 1, -1, -2, -2, -1, 1, 2}, {1, 2, 2, 1, -1, -2, -2, -1}}); // KNIGHT - directions
    }

    private static Integer[] getXDirections(Direction direction) {
        return directionsArray.get(direction)[0];
    }

    private static Integer[] getYDirections(Direction direction) {
        return directionsArray.get(direction)[1];
    }

    /**
     * Give the list of possible ways to move.
     *
     * @param direction requested direction.
     * @return list of Move(dx, dy)
     */
    public static List<Move> getMoves(Direction direction) {
        List<Move> moves = new ArrayList<>();
        Integer[] xDirections = getXDirections(direction);
        Integer[] yDirections = getYDirections(direction);

        for (int i = 0, ln = xDirections.length; i < ln; i++) {
            moves.add(Move.of(xDirections[i], yDirections[i]));
        }
        return moves;
    }
}
