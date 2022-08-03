package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

public class TicTacToe {

    char[][] board = new char[3][];

    boolean win(char who) {
        for (int i = 0; i < 3; i++) if (board[i][0] == who && board[i][1] == who && board[i][2] == who) return true;
        for (int i = 0; i < 3; i++) if (board[0][i] == who && board[1][i] == who && board[2][i] == who) return true;
        if (board[0][0] == who && board[1][1] == who && board[2][2] == who) return true;
        return board[0][2] == who && board[1][1] == who && board[2][0] == who;
    }

    int count(char who) {
        int count = 0;
        for (char[] row : board) for (char col : row) if (col == who) count++;
        return count;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int tCases = in.readInteger();
        for (int cs = 1; cs <= tCases; ++cs) {
            for (int i = 0; i < 3; i++) {
                String row = in.readString();
                board[i] = row.toCharArray();
            }
            int countX = count('X');
            int countO = count('O');

            if (countO > countX || countX - countO > 1) out.printLine("no");
            else {
                boolean winX = win('X');
                boolean winO = win('O');

                if (winX && winO) out.printLine("no");
                else if (winX) {
                    if (countX > countO) out.printLine("yes");
                    else out.printLine("no");
                } else if (winO) {
                    if (countO == countX) out.printLine("yes");
                    else out.printLine("no");
                } else out.printLine("yes");
            }
        }
    }
}
