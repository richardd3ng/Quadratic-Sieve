package algorithms;

import java.math.BigInteger;
import java.util.*;

import static constants.Constants.*;

/**
 * Class of utility functions for Quadratic Sieve and general math procedures
 */
public class MathUtil {
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
            if (DEBUG_EUCLIDEAN_ALGORITHM) {
                System.out.printf("%s = %s(%s) + %s\n", a, q, b, r); // show steps
            }
            if (r.equals(ZERO)) { // guaranteed to escape loop when remainder is zero
                return b;
            }
            a = b;
            b = r;
        }
    }

    public static int getBound(BigInteger num) {
//        // TODO: complete this method
//        BigInteger x = num.sqrt().multiply(num.sqrt().sqrt().sqrt());
//        BigDecimal temp1 =  new BigDecimal(5.5129);
//        BigDecimal B = new BigDecimal();
//        B = temp1.multiply(this.BigLog(x).multiply(this.BigLog(this.BigLog(x))).sqrt());
//
//        return B;
        return 19;
    }
//    public static BigDecimal BigLog(BigInteger num){
//        BigInteger temp = num.bitCount();
//        BigDecimal log = new BigDecimal(temp);
//        log = log.divide(3.32192809489);
//        return log;
//
//    }


    /**
     * Generates the list of primes less than or equal to a bound using the Sieve of Eratosthenes
     *
     * @param bound an integer bound > 1
     * @return the primes less than or equal to bound
     */
    public static List<Integer> getFactorBase(int bound) {
        boolean[] remaining = new boolean[bound + 1];
        Arrays.fill(remaining, true);
        for (int i = 2; i * i < bound; i++) {
            if (remaining[i]) {
                for (int j = i * i; j <= bound; j += i) {
                    remaining[j] = false;
                }
            }
        }
        List<Integer> factorBase = new ArrayList<>();
        for (int i = 2; i <= bound; i++) {
            if (remaining[i]) {
                factorBase.add(i);
            }
        }
        return factorBase;
    }

    public static BigInteger computeListProduct(List<Integer> list) {
        BigInteger product = BigInteger.ONE;
        for (Integer val : list) {
            product = product.multiply(new BigInteger(String.valueOf(val)));
        }
        return product;
    }

    /**
     * Determines whether a number is B-smooth
     * https://math.stackexchange.com/questions/182398/smooth-numbers-algorithm
     *
     * @param n                 the number to be tested for B-smoothness
     * @param factorBaseProduct the product of primes less than a bound B in the factor base
     * @return whether n is B-smooth
     */
    public static boolean isBSmooth(BigInteger n, BigInteger factorBaseProduct) {
        while (true) {
            BigInteger g = MathUtil.gcd(n, factorBaseProduct);
            if (g.compareTo(ONE) == 0) { // if gcd of 1 is reached, then n is not smooth
                break;
            }
            // try to find integers r and e such that n = rg^e => first check if n (mod g^e) = 0
            for (int e = 1; g.pow(e).compareTo(n) <= 0; e++) {
                BigInteger gPowE = g.pow(e);
                if (n.mod(gPowE).compareTo(ZERO) == 0) {
                    BigInteger r = n.divide(gPowE);
                    if (r.compareTo(ONE) == 0) { // if r = 1, then n is smooth
                        return true;
                    }
                    n = r; // otherwise, set n = r and repeat the outer loop
                    break;
                }
            }
        }
        return false;
    }

    public static BigInteger[] getLinearCombo(Set<BigInteger> BSmoothNumbers) {
        // TODO: complete this method
        return new BigInteger[]{new BigInteger("735"), new BigInteger("801")};
    }

}
