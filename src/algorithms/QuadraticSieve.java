package algorithms;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static constants.Constants.*;

public class QuadraticSieve {

    public static BigInteger[] factorize(BigInteger n) {
        int B = getBound(n);
        Set<Integer> factorBase = getFactorBase(B);
        int t = factorBase.size();

        Set<BigInteger> BSmoothNumbers = new HashSet<>();

//        while (BSmoothNumbers.size() < t + 1) {
//            // quadratic sieve here
//        }

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

    private static BigInteger[] getLinearCombo(Set<BigInteger> BSmoothNumbers) {
        return new BigInteger[]{new BigInteger("735"), new BigInteger("801")};
    }

}
