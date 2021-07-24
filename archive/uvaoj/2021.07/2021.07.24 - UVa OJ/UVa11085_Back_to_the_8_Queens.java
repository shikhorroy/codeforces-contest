package roy.coder;

import roy.coder.utils.io.OutputWriter;

import java.util.Arrays;
import java.util.Scanner;

public class UVa11085_Back_to_the_8_Queens {

    private final int[] queenPlaceOnRow = new int[8];//~ e.g. queenPlaceOnRow[0] = 3 means for column 0 queen placed on row 3.
    private final int[] initQueenPlacedOnRow = new int[8];

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
            return this.calculateTotalMovesRequired();
        }

        int minMoves = Integer.MAX_VALUE;
        for (int row = 0; row < 8; row++) {
            if (isValidPosition(row, col - 1)) {
                queenPlaceOnRow[col - 1] = row;
                minMoves = Math.min(minMoves, solve(col + 1));
                queenPlaceOnRow[col - 1] = -1;
            }
        }
        return minMoves;
    }

    private int calculateTotalMovesRequired() {
        int count = 0;
        boolean found = true;
        for (int c = 0; c < 8; c++) {
            if (queenPlaceOnRow[c] == -1) {
                found = false;
                break;
            }
            if (queenPlaceOnRow[c] != initQueenPlacedOnRow[c]) count++;
        }
        return found ? count : Integer.MAX_VALUE;
    }

    public void solve(int testNumber, Scanner in, OutputWriter out) {
        int tCase = 1;
        while (in.hasNext()) {
            for (int c = 0; c < 8; c++) initQueenPlacedOnRow[c] = (in.nextInt() - 1);

            Arrays.fill(queenPlaceOnRow, -1);
            out.printLine(String.format("Case %d: %d", tCase++, this.solve(1)));
        }
    }
}
