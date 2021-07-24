package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class UVa10452_Marcus {

    private StringBuilder ans;

    private void solve(List<String> map, int x, int y, int pathIndex) {
        String PATH = "IEHOVA#";
        if (pathIndex == PATH.length()) return;

        /* MAP:
         * r\c 0 1 2 3 4
         *  0 A B C D #
         *  1 A M M A K
         *  2 M M O V I
         *  3 X Y H A O
         *  4 D D G @ U
         * if position is P(4, 3), then,
         * right => (4, 4)
         * left => (4, 2)
         * top => (3, 3)
         */
        int goRight_y = y + 1;
        int goLeft_y = y - 1;
        int goTop_x = x - 1;
        String row = map.get(x);
        if (goRight_y < row.length() && row.charAt(goRight_y) == PATH.charAt(pathIndex)) {
            if (ans.length() > 0) ans.append(" ");
            ans.append("right");
            solve(map, x, goRight_y, pathIndex + 1);
        } else if (goLeft_y >= 0 && row.charAt(goLeft_y) == PATH.charAt(pathIndex)) {
            if (ans.length() > 0) ans.append(" ");
            ans.append("left");
            solve(map, x, goLeft_y, pathIndex + 1);
        } else if (goTop_x >= 0) {
            String prevRow = map.get(goTop_x);
            if (prevRow.charAt(y) == PATH.charAt(pathIndex)) {
                if (ans.length() > 0) ans.append(" ");
                ans.append("forth");
                solve(map, goTop_x, y, pathIndex + 1);
            }
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int tCase = in.readInteger();

        for (int cs = 0; cs < tCase; cs++) {
            int m = in.readInteger();
            int n = in.readInteger();

            List<String> map = new ArrayList<>();
            for (int i = 0; i < m; i++) map.add(in.next());

            int x = m - 1, y = 0;
            String lastRow = map.get(x);
            for (int i = 0; i < n; i++) {
                if (lastRow.charAt(i) == '@') {
                    y = i;
                    break;
                }
            }
            ans = new StringBuilder();
            this.solve(map, x, y, 0);
            out.printLine(ans);
        }
    }
}
