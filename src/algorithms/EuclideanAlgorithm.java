package algorithms;

import java.math.BigInteger;

import static constants.Constants.*;

public class EuclideanAlgorithm {

    /**
     * Computes gcd(a, b) via the Euclidean Algorithm
     *
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of a and b
     */
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        // make negative inputs positive
        a = a.abs();
        b = b.abs();
        if (b.compareTo(a) > 0) { // assume a >= b, swap inputs if b > a
            return gcd(b, a);
        }
        // if either a or b is zero, return the other number
        if (a.equals(ZERO)) {
            return b;
        }
        if (b.equals(ZERO)) {
            return a;
        }
        while (true) {  // main loop of Euclidean Algorithm
            BigInteger q = a.divide(b);
            BigInteger r = a.subtract(q.multiply(b));
            if (DEBUG) {
                System.out.printf("%s = %s(%s) + %s\n", a, q, b, r); // show steps
            }
            if (r.equals(ZERO)) { // guaranteed to escape loop when remainder is zero
                return b;
            }
            a = b;
            b = r;
        }
    }
}
