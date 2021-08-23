package roy.coder.utils.algo.math.primes;

import java.util.ArrayList;
import java.util.List;

public class Sieve {
    private final int n;
    private final List<Boolean> isPrime;
    private final List<Integer> primes = new ArrayList<>();

    private void generatePrimes() {
        //~ implementation details: https://shikhorroy.wordpress.com/2013/11/12/wp-mep2mliv-5r/
        if (n >= 0) isPrime.set(0, false);
        if (n >= 1) isPrime.set(1, false);
        if (n >= 2) isPrime.set(2, true);
        for (int i = 3; i <= n; i += 2) isPrime.set(i, true);

        if (n >= 2) primes.add(2);
        for (int x = 3; x <= n; x += 2) {//~ apply sieve method only for odd numbers
            if (isPrime.get(x)) {
                primes.add(x);
                if ((long) x * x <= n) for (int i = x * x; i <= n; i += (2 * x)) {
                    isPrime.set(i, false);
                }
            }
        }
    }

    public Sieve(int n) {
        this.n = n;
        isPrime = new ArrayList<>();
        for (int i = 0; i <= n; i++) isPrime.add(false);
        this.generatePrimes();
    }

    /**
     * Find if a number is prime or not.
     *
     * @param x the number to check
     * @return true or false
     */
    public boolean isPrime(int x) {
        if (x > n) throw new RuntimeException(x + " is out of range.");
        return isPrime.get(x);
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

    public List<Integer> getPrimeDivisors(int number) {
        List<Integer> primeDivisorList = new ArrayList<>();
        this.primeDivisors(number, primeDivisorList);

        return primeDivisorList;
    }

    public int getPrimeDivisorsCount(int number) {
        return this.primeDivisors(number, null);
    }

    private int primeDivisors(int number, List<Integer> divisors) {
        if (this.count() == 0) this.generatePrimes();//~ for safety purpose

        boolean doGenerateList = divisors != null;

        int temp = number, count = 0;
        List<Integer> primeList = this.getPrimes();
        for (Integer p : primeList) {
            if ((long) p * p <= temp) while (number % p == 0) {
                ++count;
                number /= p;
                if (doGenerateList) divisors.add(p);
            }
        }
        if (number > 1) {
            ++count;
            if (doGenerateList) divisors.add(number);
        }
        return count;
    }
}
