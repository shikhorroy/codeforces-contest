package roy.coder.utils.algo.math.counting;

import java.util.ArrayList;
import java.util.List;

/**
 * Euler's totient function, also known as phi-function,
 * counts the number of integers between 1 and n inclusive, which are co-prime to n.
 * Complexity: O(n log log n)
 */
public class EulerTotient {

    /**
     * <h3>Properties of Euler's Totient Function:</h3>
     * <ol>
     *     <li>If p is a prime number, then ϕ(p) = p−1</li>
     *     <li>
     *         If p is a prime number and m is a positive integer (that is, m ≥ 1),
     *         then ϕ(p<sup>m</sup>) = p<sup>m</sup> − p<sup>m - 1</sup>
     *     </li>
     *     <li>
     *         For any two positive integers m and n,
     *         <p>we have ϕ(mn) = ϕ(m) x ϕ(n) x gcd(m,n) / ϕ(gcd(m,n)).</p>
     *         Considering the case when m and n are coprime,
     *         then gcd(m,n) = 1. In such a scenario, the above relation reduces to ϕ(mn) = ϕ(m) x ϕ(n)
     *     </li>
     *     <li>
     *         The sum of values of the totient function over the positive divisors of n equals n itself.
     *         <p>In other words: ∑ϕ(k) = n, where k are the divisors.</p>
     *     </li>
     *     <li>
     *         If m and n are two prime numbers, then using (1) and (3), we get:<p>
     *         ϕ(mn) = ϕ(m) x ϕ(n) = (m−1) x (n−1)
     *     </li>
     * </ol>
     */
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
