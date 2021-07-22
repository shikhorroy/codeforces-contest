package roy.coder;

import roy.coder.utils.algo.recursion.tower_of_hanoi.TowerOfHanoi;

public class Main {

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(3, "1", "3", "2");
        towerOfHanoi.solve();
    }
}
