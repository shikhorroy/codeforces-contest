package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.Arrays;

public class UVa167_The_Sultans_Successors {

    private final int[][] board = new int[8][8];
    private final int[] queenPlaceOnRow = new int[8];//~ e.g. queenPlaceOnRow[0] = 3 means for column 0 queen placed on row 3.

    private boolean isValidPosition(int row, int col) {
        for (int c = 0; c < col; c++) {
            if (queenPlaceOnRow[c] == -1) continue;

            if (queenPlaceOnRow[c] == row) return false;

            /*
             * considered: 0 - index base chess board.
             * let, a queen placed on P(3, 2), then, for column 4, diagonal for P will be,
             * P1(1, 4) and P2(5, 4). Here, for P1 and P2,
             * row(1 and 5) => row of P(3, 2) (+/-) (column of P1(1, 4) - column of P(3, 2))
             * => 3 (+/-) (4 - 2) => 3 (+/-) 2 => 1 and 5.
             */
            int diff = col - c;
            int row1 = queenPlaceOnRow[c] - diff;
            int row2 = queenPlaceOnRow[c] + diff;
            if (row == row1 || row == row2) return false;
        }
        return true;
    }

    private int solve(int col) {
        if (col == 9) {
            return this.calculateTotal();
        }

        int maxTotal = 0;
        for (int row = 0; row < 8; row++) {
            if (isValidPosition(row, col - 1)) {
                queenPlaceOnRow[col - 1] = row;
                maxTotal = Math.max(maxTotal, solve(col + 1));
                queenPlaceOnRow[col - 1] = -1;
            }
        }
        return maxTotal;
    }

    private int calculateTotal() {
        int total = 0;
        boolean found = true;
        for (int c = 0; c < 8; c++) {
            if (queenPlaceOnRow[c] == -1) {
                found = false;
                break;
            }
            total += board[queenPlaceOnRow[c]][c];
        }
        return found ? total : 0;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.readInteger();
        for (int cs = 0; cs < t; cs++) {

            for (int r = 0; r < 8; r++)
                for (int c = 0; c < 8; c++)
                    board[r][c] = in.readInteger();

            Arrays.fill(queenPlaceOnRow, -1);
            System.out.printf("%5d\n", this.solve(1));
        }
    }
}
