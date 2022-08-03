package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HardestProblemEverEasy {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        char[][] names = {
                {'R', 'A', 'K', 'I', 'B', 'U', 'L'},
                {'A', 'N', 'I', 'N', 'D', 'Y', 'A'},
                {'M', 'O', 'S', 'H', 'I', 'U', 'R'},
                {'S', 'H', 'I', 'P', 'L', 'U'},
                {'K', 'A', 'B', 'I', 'R'},
                {'S', 'U', 'N', 'N', 'Y'},
                {'O', 'B', 'A', 'I', 'D', 'A'},
                {'W', 'A', 'S', 'I'}
        };
        char[][] matrix = {
                {'O', 'B', 'I', 'D', 'A', 'I', 'B', 'K', 'R'},
                {'R', 'K', 'A', 'U', 'L', 'H', 'I', 'S', 'P'},
                {'S', 'A', 'D', 'I', 'Y', 'A', 'N', 'N', 'O'},
                {'H', 'E', 'I', 'S', 'A', 'W', 'H', 'I', 'A'},
                {'I', 'R', 'A', 'K', 'I', 'B', 'U', 'L', 'S'},
                {'M', 'F', 'B', 'I', 'N', 'T', 'R', 'N', 'O'},
                {'U', 'T', 'O', 'Y', 'Z', 'I', 'F', 'A', 'H'},
                {'L', 'E', 'B', 'S', 'Y', 'N', 'U', 'N', 'E'},
                {'E', 'M', 'O', 'T', 'I', 'O', 'N', 'A', 'L'}
        };

        for (char[] chars : names) {
            StringBuilder name = new StringBuilder();
            Map<Character, Integer> frequency = new HashMap<>();
            for (char aChar : chars) {
                name.append(aChar);
                frequency.put(aChar, frequency.getOrDefault(aChar, 0) + 1);
            }

            int count = 0, nameLn = name.length();
            for (int row = 0; row < 9; row++) {// horizontal match:
                for (int col = 0, ln = 9 - nameLn; col <= ln; col++) {
                    Map<Character, Integer> matFrequency = new HashMap<>();
                    for (int c = col; c < col + nameLn; c++) {
                        matFrequency.put(matrix[row][c], matFrequency.getOrDefault(matrix[row][c], 0) + 1);
                    }
                    boolean found = true;
                    if (matFrequency.size() == frequency.size()) for (Character c : matFrequency.keySet()) {
                        if (frequency.containsKey(c) && Objects.equals(frequency.get(c), matFrequency.get(c))) ;
                        else {
                            found = false;
                            break;
                        }
                    }
                    else found = false;
                    if (found) {
                        count++;
                    }
                }
            }
//            System.out.println(name + " " + count);
            if (count == 2) {
                out.printLine(name);
                return;
            }

            count = 0;
            for (int col = 0; col < 9; col++) {// vertical match:
                for (int row = 0, ln = 9 - nameLn; row <= ln; row++) {
                    Map<Character, Integer> matFrequency = new HashMap<>();
                    for (int r = row; r < row + nameLn; r++) {
                        matFrequency.put(matrix[r][col], matFrequency.getOrDefault(matrix[r][col], 0) + 1);
                    }
                    boolean found = true;
                    if (matFrequency.size() == frequency.size()) for (Character c : matFrequency.keySet()) {
                        if (frequency.containsKey(c) && Objects.equals(frequency.get(c), matFrequency.get(c))) ;
                        else {
                            found = false;
                            break;
                        }
                    }
                    else found = false;

                    if (found) {
                        count++;
                    }
                }
            }
//            System.out.println(name + " " + count);
            if (count == 2) {
                out.printLine(name);
                return;
            }
        }
    }
}
