package roy.coder.utils.algo.math.cycle;

import roy.coder.utils.utility.Pair;

public abstract class FloydCycle {

    public abstract int f(int x);

    //~ Source taken from CP3(P-225).
    public Pair<Integer, Integer> detect(int x0) { // function int f(int x) is defined earlier
        // 1st part: finding k*mu, hare’s speed is 2x tortoise’s
        int tortoise = f(x0), hare = f(f(x0)); // f(x0) is the node next to x0
        while (tortoise != hare) {
            tortoise = f(tortoise);
            hare = f(f(hare));
        }
        // 2nd part: finding mu, hare and tortoise move at the same speed
        int mu = 0;
        hare = x0;
        while (tortoise != hare) {
            tortoise = f(tortoise);
            hare = f(hare);
            mu++;
        }
        // 3rd part: finding lambda, hare moves, tortoise stays
        int lambda = 1;
        hare = f(tortoise);
        while (tortoise != hare) {
            hare = f(hare);
            lambda++;
        }
        return Pair.of(mu, lambda);
    }
}
