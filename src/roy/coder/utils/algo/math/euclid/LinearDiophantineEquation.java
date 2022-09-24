package roy.coder.utils.algo.math.euclid;

public class LinearDiophantineEquation {

    public static class Solution {
        public long x, y, g;
        public boolean hasSolution;

        public Solution(boolean hasSolution, long x, long y, long g) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.hasSolution = hasSolution;
        }
    }

    // Linear Diophantine equation can have infinitely many solutions.
    // Here, following method will calculate one of the solution:
    public static Solution findAnySolution(long a, long b, long c) {
        Euclid.Tuple t = Euclid.extendedGCD(Math.abs(a), Math.abs(b));
        if (c % t.g != 0) return new Solution(false, -1, -1, -1);

        t.x *= (double) c / t.g;
        t.y *= (double) c / t.g;
        if (a < 0) t.x = -t.x;
        if (b < 0) t.y = -t.y;
        return new Solution(true, t.x, t.y, t.g);
    }
    // Given, linear diophantine equation: a * x + b * y = c
    // let's say (x0, y0) is one of the solution, then we can write: a * x0 + b * y0 = c.
    // Now, we should see that adding b/g to x0, and, at the same time subtracting a/g from y0 will not break the equality:
    // a * (x0 + b/g) + b * (y0 - a/g) = a * x0 + (a * b/g) + b * y0 - (b  * a/g) = a * x0 + b * y0 = c.
    // obviously this process can be repeated, so all the numbers of the form:
    // x = x0 + n * (b / g)
    // y = y0 - n * (a / g)
}
