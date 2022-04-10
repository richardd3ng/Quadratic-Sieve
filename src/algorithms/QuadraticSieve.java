package algorithms;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static constants.Constants.*;

public class QuadraticSieve {

    public static BigInteger[] factorize(BigInteger n) {
        int B = MathUtil.getBound(n);
        Set<Integer> factorBase = MathUtil.getFactorBase(B);
        BigInteger factorBaseProduct = MathUtil.computeSetProduct(factorBase);
        int t = factorBase.size();

        Set<BigInteger> BSmoothNumbers = new HashSet<>();
        // construct a sieving interval of length 2B around floor(n), think about this more
        // look for numbers in sieving interval of length 2*factor*B around sqrt(n), sqrt(2n), sqrt(3n), etc.
        int scale = 1; // sieving interval centered around sqrt(scale * n)
        while (BSmoothNumbers.size() < t + 1) {
            BigInteger start = n.multiply(new BigInteger(String.valueOf(scale))).sqrt()
                    .subtract(new BigInteger(String.valueOf(SIEVING_INTERVAL_B_FACTOR * B)));
            int idx = 0;
            while (idx <= 2 * SIEVING_INTERVAL_B_FACTOR * B) {
                if (BSmoothNumbers.size() == t + 1) {
                    break;
                }
                BigInteger candidate = start.add(new BigInteger(String.valueOf(idx)));
                System.out.println("scale: " + scale);
                System.out.println("candidate: " + candidate);
                System.out.println("found: " + BSmoothNumbers.size());
                if (MathUtil.isBSmooth(candidate.pow(2), factorBaseProduct)) {
                    BSmoothNumbers.add(candidate);
                }
                idx++;
            }
            scale++;
        }


        BigInteger[] linearCombo = MathUtil.getLinearCombo(BSmoothNumbers);
        BigInteger x = linearCombo[0].multiply(linearCombo[1]).mod(n);
        BigInteger y = new BigInteger("5984");

        // compute the 2 factors from x, y, and n
        BigInteger factor1 = MathUtil.gcd(x.subtract(y), n);
        BigInteger factor2 = n.divide(factor1);

        if (DEBUG_QUADRATIC_SIEVE) {
            System.out.print("BSmooth set: ");
            for (BigInteger bigInt : BSmoothNumbers) {
                System.out.print(bigInt + " ");
            }
            System.out.println();
            System.out.printf("x = %s, y = %s", x, y);
            System.out.println();
            System.out.printf("%s = %s * %s", n, factor1, factor2);
        }
        return new BigInteger[]{factor1, factor2};
    }

  
}
