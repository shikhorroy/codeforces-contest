package roy.coder;

import roy.coder.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVa628_Passwords {

    private List<String> dictionary;
    private final StringBuilder ans = new StringBuilder();

    private void solve(String rule, int i, String password) {
        if (i == rule.length()) {
            ans.append(password).append("\n");
            return;
        }

        if (rule.charAt(i) == '#') for (String word : dictionary)
            this.solve(rule, i + 1, password + word);
        else for (int d = 0; d < 10; d++)
            this.solve(rule, i + 1, password + d);
    }

    public void solve(int testNumber, Scanner in, OutputWriter out) {
        while (in.hasNext()) {
            int n = in.nextInt();
            dictionary = new ArrayList<>();
            for (int i = 0; i < n; i++) dictionary.add(in.next());

            int m = in.nextInt();
            List<String> rules = new ArrayList<>();
            for (int i = 0; i < m; i++) rules.add(in.next());

            ans.append("--").append("\n");
            for (String rule : rules) {
                this.solve(rule, 0, "");
            }
        }
        out.print(ans);
    }
}
