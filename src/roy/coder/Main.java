package roy.coder;

import roy.coder.utils.algo.math.primes.Sieve;

public class Main {
    public static void main(String[] args) {
        Sieve sieve = new Sieve(2);
        System.out.println(sieve.isPrime(10));
    }
}
