package roy.coder.utils.io;

import roy.coder.utils.utility.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class InputReader {

    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
    private final InputStream stream;
    private final byte[] buf = new byte[1024];

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private long readWholeNumber(int c) {
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);

            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int readInteger() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = (int) readWholeNumber(c);
        return res * sgn;
    }

    public char readCharacter() {
        int c;
        for (c = this.read(); isSpaceChar(c); c = this.read()) ;
        return (char) c;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String readLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isNewlineChar(c));
        return res.toString();
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, readInteger());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInteger());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = readWholeNumber(c);
        return res * sgn;
    }

    public String next() {
        return readString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isNewlineChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return c == '\n' || c == -1;
    }

    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }

    //~ Input Helper Methods :: start ~//
    public List<Integer> readIntegerList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(readInteger());
        return list;
    }

    public int[] readIntegerArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = readInteger();
        return arr;
    }

    public List<Long> readLongList(int n) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(readLong());
        return list;
    }

    public long[] readLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = readLong();
        return arr;
    }

    public List<Double> readDoubleList(int n) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(readDouble());
        return list;
    }

    public double[] readDoubleArray(int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) arr[i] = readInteger();
        return arr;
    }

    public List<String> readStringList(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(readString());
        return list;
    }

    public String[] readStringArray(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = readString();
        return arr;
    }

    public List<Pair<Integer, Integer>> readIntIntPairList(int n) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(Pair.of(readInteger(), readInteger()));
        return list;
    }

    public List<Pair<Double, Double>> readDoubleDoublePairList(int n) {
        List<Pair<Double, Double>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(Pair.of(readDouble(), readDouble()));
        return list;
    }

    public List<Pair<Integer, String>> readIntStringPairList(int n) {
        List<Pair<Integer, String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(Pair.of(readInteger(), readString()));
        return list;
    }

    public List<Pair<String, Integer>> readStringIntPairList(int n) {
        List<Pair<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(Pair.of(readString(), readInteger()));
        return list;
    }

    public List<Pair<String, String>> readStringStringPairList(int n) {
        List<Pair<String, String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(Pair.of(readString(), readString()));
        return list;
    }

    public Set<Integer> readIntegerSet(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(readInteger());
        return set;
    }

    public Set<Long> readLongSet(int n) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(readLong());
        return set;
    }

    public Set<String> readStringSet(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(readString());
        return set;
    }
    //~ Input Helper Methods :: end ~//
}
