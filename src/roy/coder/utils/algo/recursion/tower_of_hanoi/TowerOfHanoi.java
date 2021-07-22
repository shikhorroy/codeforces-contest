package roy.coder.utils.algo.recursion.tower_of_hanoi;

/**
 * Algorithm: IBH (Induction Base Hypothesis) recursion to solve Tower of Hanoi.
 */
public class TowerOfHanoi {

    private final int platesCount;
    private final String sourceTower;
    private final String helperTower;
    private final String destinationTower;

    public TowerOfHanoi(int platesCount, String sourceTower, String destinationTower, String helperTower) {
        this.platesCount = platesCount;
        this.sourceTower = sourceTower;
        this.helperTower = helperTower;
        this.destinationTower = destinationTower;
    }

    private void printSolution(int platesCount, String sourceTower, String destinationTower, String helperTower) {
        //~ Base:
        if (platesCount == 1) {
            System.out.println("Move plate - " + platesCount + " from " + sourceTower + " to " + destinationTower);
            return;
        }

        //~ Hypothesis:
        printSolution(platesCount - 1, sourceTower, helperTower, destinationTower);
        //~ Induction:
        System.out.println("Move plate - " + platesCount + " from " + sourceTower + " to " + destinationTower);
        //~ Hypothesis:
        printSolution(platesCount - 1, helperTower, destinationTower, sourceTower);
    }

    public void solve() {
        this.printSolution(this.platesCount, this.sourceTower, this.destinationTower, this.helperTower);
    }
}
