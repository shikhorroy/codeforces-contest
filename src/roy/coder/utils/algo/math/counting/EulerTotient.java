package roy.coder.utils.algo.math.counting;

import java.util.ArrayList;
import java.util.List;

/**
 * Euler's totient function, also known as phi-function,
 * counts the number of integers between 1 and n inclusive, which are co-prime to n.
 */
public class EulerTotient {

    public static List<Integer> calculate(int n) {
        List<Integer> phi = new ArrayList<>();
        for (int i = 0; i <= n; i++) phi.add(i);

        for (int i = 2; i <= n; i++) {
            if (phi.get(i) == i) {
                for (int j = i; j <= n; j += i)
                    phi.set(j, phi.get(j) - phi.get(j) / i);
            }
        }
        return phi;
    }
}
