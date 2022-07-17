package roy.coder.utils.algo.dirarray;


/**
 * Tiny little Move class, contains moving toward dx and dy direction.
 */
public class Move {
    public int dx;
    public int dy;

    private Move(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    static Move of(int dx, int dy) {
        return new Move(dx, dy);
    }
}
