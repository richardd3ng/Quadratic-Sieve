package algorithms;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static constants.Constants.*;

public class QuadraticSieve {

    public static BigInteger[] factorize(BigInteger n) {
        int B = getBound(n);
        Set<Integer> factorBase = getFactorBase(B);
        BigInteger factorBaseProduct = getFactorBaseProduct(factorBase);
        int t = factorBase.size();

        Set<BigInteger> BSmoothNumbers = new HashSet<>();

        // construct a sieving interval of length 2∗B around floor(n), think about this more
        BigInteger[] sievingInterval = getSievingInterval(n, B);
        BigInteger start = sievingInterval[0], end = sievingInterval[1];

        int idx = 0;
        while (BSmoothNumbers.size() < t + 1) {
            BigInteger candidate = start.add(new BigInteger(String.valueOf(idx)));
            System.out.println("candidate: " + candidate);
            if (isBSmooth(candidate.pow(2), factorBaseProduct)) {
                BSmoothNumbers.add(candidate);
                System.out.println("adding: " + candidate);
            }
            idx++;
        }
        for (BigInteger bigInt : BSmoothNumbers) {
            System.out.print(bigInt + " ");
        }

        BigInteger[] linearCombo = getLinearCombo(new HashSet<>());
        BigInteger x = linearCombo[0].multiply(linearCombo[1]).mod(n);
        BigInteger y = new BigInteger("5984");

        if (DEBUG_QUADRATIC_SIEVE) {
            System.out.printf("x = %s, y = %s", x, y);
        }

        // compute the 2 factors from x, y, and n
        BigInteger factor1 = EuclideanAlgorithm.gcd(x.subtract(y), n);
        BigInteger factor2 = n.divide(factor1);

        if (DEBUG_QUADRATIC_SIEVE) {
            System.out.println();
            System.out.printf("%s = %s * %s", n, factor1, factor2);
        }
        return new BigInteger[]{factor1, factor2};
    }

    // TODO: set this bound
    private static int getBound(BigInteger num) {
        return 19;
    }

    private static Set<Integer> getFactorBase(int bound) {
        return Set.of(2, 3, 5, 7, 11, 13, 17);
    }

    private static BigInteger getFactorBaseProduct(Set<Integer> factorBase) {
        BigInteger product = BigInteger.ONE;
        for (Integer prime : factorBase) {
            product = product.multiply(new BigInteger(String.valueOf(prime)));
        }
        return product;
    }

    private static BigInteger[] getSievingInterval(BigInteger n, int bound) {
        BigInteger B = new BigInteger(String.valueOf(bound));
        BigInteger sqrtN = n.sqrt(); // computes floor(sqrt(n))
        System.out.println("start: " + sqrtN.subtract(B));
        return new BigInteger[]{sqrtN.subtract(B), sqrtN.add(B)};
    }

    /**
     * Determines whether a number is B-smooth
     *
     * @param n          the number to be tested for B-smoothness
     * @param factorBaseProduct the product of primes less than a bound B in the factor base
     * @return whether n is B-smooth
     */
    // TODO: change this to private when done testing
    public static boolean isBSmooth(BigInteger n, BigInteger factorBaseProduct) {
        while (true) {
            BigInteger g = EuclideanAlgorithm.gcd(n, factorBaseProduct);
            if (g.compareTo(ONE) == 0) {
                break;
            }
            // try to find e such that g
            for (int e = 1; g.pow(e).compareTo(n) <= 0; e++) {
                BigInteger gPowE = g.pow(e);
                if (n.mod(gPowE).compareTo(ZERO) == 0) {
                    BigInteger r = n.divide(gPowE);
                    if (r.compareTo(ONE) == 0) {
                        return true;
                    }
                    n = r;
                    break;
                }
            }
        }
        return false;
    }

    private static BigInteger[] getLinearCombo(Set<BigInteger> BSmoothNumbers) {
        return new BigInteger[]{new BigInteger("735"), new BigInteger("801")};
    }

}
