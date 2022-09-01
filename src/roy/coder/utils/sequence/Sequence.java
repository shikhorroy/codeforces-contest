package roy.coder.utils.sequence;


public interface Sequence {

    /**
     * In combinatorial mathematics, the Catalan numbers are a sequence of natural numbers
     * <p>
     * that occur in various counting problems, often involving recursively defined objects.
     * <p>
     * They are named after the French-Belgian mathematician Eugène Charles Catalan (1814–1894).
     * <p>
     * The n<sup>th</sup> Catalan number can be expressed directly in terms of binomial coefficients by
     * <sup>2n</sup>C<sub>n</sub> / n + 1
     * <p>
     * Source: <a href="https://en.wikipedia.org/wiki/Catalan_number">Wikipedia</a>
     */
    //~ 0 to 35-th Catalan number sequence:
    long[] catalan = {
            1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670,
            129644790, 477638700, 1767263190, 6564120420L, 24466267020L, 91482563640L, 343059613650L, 1289904147324L,
            4861946401452L, 18367353072152L, 69533550916004L, 263747951750360L, 1002242216651368L, 3814986502092304L,
            14544636039226909L, 55534064877048198L, 212336130412243110L, 812944042149730764L, 3116285494907301262L,
    };
}
