package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class UVa10276_Hanoi_Tower_Troubles_Again {

    private final int[] ans = new int[55];
    private final List<List<Integer>> towerList = new ArrayList<>();

    private void populateTowerList() {
        List<Integer> newTower = new ArrayList<>();
        newTower.add(1);
        towerList.add(newTower);

        int seq = 2;
        while (towerList.size() != 51) {
            boolean square = false;
            for (List<Integer> each : towerList) {
                int item = each.get(each.size() - 1);
                int sum = item + seq;
                int squareRoot = (int) Math.sqrt(sum);
                if (squareRoot * squareRoot == sum) {
                    each.add(seq++);
                    square = true;
                    break;
                }
            }
            if (!square) {
                ans[towerList.size()] = seq - 1;
                newTower = new ArrayList<>();
                newTower.add(seq++);
                towerList.add(newTower);
            }
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        this.populateTowerList();

        int tCase = in.readInteger();
        for (int cs = 0; cs < tCase; cs++) {
            out.printLine(this.ans[in.readInteger()]);
        }
    }
}
