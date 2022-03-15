package Algorithms;

import java.math.BigInteger;

public class EuclideanAlgorithm {

    /**
     * Computes gcd(a, b) via the Euclidean Algorithm
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of a and b
     */
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        a = a.abs();
        b = b.abs();
        if (b.compareTo(a) > 0) { // assume a > b
            return gcd(b, a);
        }
        if (a.equals(BigInteger.ZERO)) {
            return b;
        }
        if (b.equals(BigInteger.ZERO)) {
            return a;
        }
        while (true) {
            BigInteger q = a.divide(b);
            BigInteger r = a.subtract(q.multiply(b));
            System.out.printf("%s = %s(%s) + %s\n", a, q, b, r);
            if (r.equals(BigInteger.ZERO)) {
                return b;
            }
            a = b;
            b = r;
        }
    }
}
