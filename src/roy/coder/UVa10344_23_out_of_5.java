package roy.coder;

import roy.coder.utils.io.InputReader;
import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UVa10344_23_out_of_5 {

    public int calculate(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                return 0;
        }
    }

    //~ ref: https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    public <T> void permute(List<T> array, int leftIndex, int rightIndex, List<List<T>> output) {
        if (leftIndex == rightIndex) {
            output.add(new ArrayList<>(array));
            return;
        }
        for (int i = leftIndex; i <= rightIndex; i++) {
            T temp = array.get(leftIndex);
            array.set(leftIndex, array.get(i));
            array.set(i, temp);

            permute(array, leftIndex + 1, rightIndex, output);

            temp = array.get(leftIndex);
            array.set(leftIndex, array.get(i));
            array.set(i, temp);
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            List<Integer> array = new ArrayList<>();
            for (int i = 0; i < 5; i++) array.add(in.readInteger());
            if (array.get(0) == 0 && array.get(1) == 0 && array.get(2) == 0 && array.get(3) == 0 && array.get(4) == 0)
                return;

            List<List<Integer>> operands = new ArrayList<>();
            permute(array, 0, 4, operands);
            List<String> operators = Arrays.asList("+", "-", "*");

            boolean isPossible = false;
            for (List<Integer> operand : operands) {
                int a1 = operand.get(0);
                int a2 = operand.get(1);
                int a3 = operand.get(2);
                int a4 = operand.get(3);
                int a5 = operand.get(4);

                for (String op1 : operators) {
                    for (String op2 : operators) {
                        for (String op3 : operators) {
                            for (String op4 : operators) {
                                //~ (((a1 o1 a2) o2 a3) o3 a4) o4 a5
                                int result = calculate(
                                        calculate(
                                                calculate(
                                                        calculate(a1, a2, op1), a3, op2
                                                ), a4, op3
                                        ), a5, op4
                                );
                                if (result == 23) {
                                    isPossible = true;
                                    break;
                                }
                            }
                            if (isPossible) break;
                        }
                        if (isPossible) break;
                    }
                    if (isPossible) break;
                }
                if (isPossible) break;
            }
            if (isPossible) out.printLine("Possible");
            else out.printLine("Impossible");
        }
    }
}
