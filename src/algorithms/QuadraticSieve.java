package algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static constants.Constants.*;

public class QuadraticSieve {

    public static BigInteger[] factorize(BigInteger n) {
        int B = MathUtil.getBound(n);
        List<Integer> factorBase = MathUtil.getFactorBase(B);
        BigInteger factorBaseProduct = MathUtil.computeListProduct(factorBase);
        int t = factorBase.size();

        List<BigInteger> BSmoothNumbers = new ArrayList<>();
        // construct a sieving interval of length 2B around floor(n), think about this more
        // look for numbers in sieving interval of length 2*factor*B around sqrt(n), sqrt(2n), sqrt(3n), etc.
        int scale = 1; // sieving interval centered around sqrt(scale * n)
        int requiredSize = 2 * t + 1;
        while (BSmoothNumbers.size() < requiredSize) {
            BigInteger start = n.multiply(new BigInteger(String.valueOf(scale))).sqrt()
                    .subtract(new BigInteger(String.valueOf(SIEVING_INTERVAL_B_FACTOR * B)));

            int idx = 0;

            while (idx <= 2 * SIEVING_INTERVAL_B_FACTOR * B) {
                if (BSmoothNumbers.size() == requiredSize) {
                    break;
                }
                BigInteger candidate = start.add(new BigInteger(String.valueOf(idx)));
                System.out.println("scale: " + scale);
                System.out.println("candidate: " + candidate);
                System.out.println("found: " + BSmoothNumbers.size());

                BigInteger modulo = candidate.pow(2).mod(n);
                if (modulo.compareTo(n.divide(BigInteger.valueOf(2))) > 0) {
                    modulo = n.subtract(modulo);
                }

                if (MathUtil.isBSmooth(modulo.abs(), factorBaseProduct)) {
                    BSmoothNumbers.add(candidate);
//                    System.out.println("CANDIDATE FOUND");
//                    System.out.print(BSmoothNumbers.size());
//                    System.out.println(" b smooth numbers found");
//                    System.out.print(requiredSize);
//                    System.out.println(" b smooth numbers needed");
                }
                idx++;
            }
            scale++;
        }

        Gaussian result = new Gaussian(BSmoothNumbers, factorBase, n);
        return result.findSolutions();
    }
}
