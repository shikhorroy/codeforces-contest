package roy.coder.utils.algo.math.primes;

import java.util.ArrayList;
import java.util.List;

public class Sieve {
    private final int n;
    private final boolean[] isPrime;
    private final List<Integer> primes = new ArrayList<>();

    private void initiate() {
        //~ implementation details: https://shikhorroy.wordpress.com/2013/11/12/wp-mep2mliv-5r/
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;
        if (n >= 2) isPrime[2] = true;
        for (int i = 3; i <= n; i += 2) isPrime[i] = true;
        for (int i = 4; i <= n; i += 2) isPrime[i] = false;

        if (n >= 2) primes.add(2);
        for (int x = 3; x <= n; x += 2) {//~ apply sieve method only for odd numbers
            if (isPrime[x]) {
                primes.add(x);
                if (x * x <= n) for (int i = x * x; i <= n; i += (2 * x)) isPrime[i] = false;
            }
        }
    }

    public Sieve(int n) {
        this.n = n;
        isPrime = new boolean[n + 1];
        initiate();
    }

    /**
     * Find if a number is prime or not.
     *
     * @param x the number to check
     * @return true or false
     */
    public boolean isPrime(int x) {
        if (x > n) throw new RuntimeException(x + " is out of range.");
        return isPrime[x];
    }

    public List<Integer> getPrimes() {
        return this.primes;
    }

    /**
     * Return i-th prime in the range of 1 to n.
     *
     * @param ith i-th prime number
     * @return the i-th prime number, otherwise, -1 if does not exists i-th prime in the range of 1 to n.
     */
    public int ithPrime(int ith) {
        if (1 <= ith && ith <= this.primes.size()) return this.primes.get(ith - 1);
        return -1;
    }

    /**
     * Count total number of primes in the range of 1 to n.
     *
     * @return total prime number count in the range of 1 to n.
     */
    public int count() {
        return this.primes.size();
    }
}
