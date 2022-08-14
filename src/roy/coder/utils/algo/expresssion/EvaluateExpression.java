package roy.coder.utils.algo.expresssion;

import java.util.Stack;

/**
 * Algo: Shunting Yard by Edgar Dijkstra.
 * Complexity: O(n)
 * <p>
 * Description:
 * 1. While there are still tokens to be read in,
 *    1.1 Get the next token.
 *    1.2 If the token is:
 *        1.2.1 A number: push it onto the value stack.
 *        1.2.2 A variable: get its value, and push onto the value stack.
 *        1.2.3 A left parenthesis: push it onto the operator stack.
 *        1.2.4 A right parenthesis:
 *          1 While the thing on top of the operator stack is not a left parenthesis,
 *              1 Pop the operator from the operator stack.
 *              2 Pop the value stack twice, getting two operands.
 *              3 Apply the operator to the operands, in the correct order.
 *              4 Push the result onto the value stack.
 *          2 Pop the left parenthesis from the operator stack, and discard it.
 *        1.2.5 An operator (call it thisOp):
 *          1 While the operator stack is not empty, and the top thing on the
 *            operator stack has the same or greater precedence as thisOp,
 *            1 Pop the operator from the operator stack.
 *            2 Pop the value stack twice, getting two operands.
 *            3 Apply the operator to the operands, in the correct order.
 *            4 Push the result onto the value stack.
 *          2 Push thisOp onto the operator stack.
 * 2. While the operator stack is not empty,
 *     1 Pop the operator from the operator stack.
 *     2 Pop the value stack twice, getting two operands.
 *     3 Apply the operator to the operands, in the correct order.
 *     4 Push the result onto the value stack.
 * 3. At this point the operator stack should be empty, and the value
 *    stack should have only one value in it, which is the final result.
 * </p>
 */
public class EvaluateExpression {

    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') sb.append(tokens[i++]);
                values.push(Integer.parseInt(sb.toString()));
                i--;
            } else if (tokens[i] == '(') ops.push(tokens[i]);
            else if (tokens[i] == ')') {
                while (ops.peek() != '(') values.push(
                        applyOp(ops.pop(), values.pop(), values.pop())
                );
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) values.push(
                        applyOp(ops.pop(), values.pop(), values.pop())
                );
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty()) values.push(
                applyOp(ops.pop(), values.pop(), values.pop())
        );

        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
