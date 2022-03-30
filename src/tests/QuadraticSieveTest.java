package tests;

import algorithms.QuadraticSieve;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for automated testing of the QuadraticSieve class
 */
public class QuadraticSieveTest {

    @Test
    void test_539874() {
        BigInteger n = new BigInteger("539873");
        BigInteger factor1 = new BigInteger("1949"), factor2 = new BigInteger("277");
        testQuadraticSieve(n, new BigInteger[]{factor1, factor2});
    }

    /**
     * Utility function for testing QuadraticSieve.factorize() against expected outputs
     *
     * @param n        the integer to be factored (product of 2 primes)
     * @param expected the expected pair of prime factors of n
     */
    private void testQuadraticSieve(BigInteger n, BigInteger[] expected) {
        BigInteger[] result = QuadraticSieve.factorize(n);
        assertTrue(result[0].compareTo(expected[0]) == 0 && result[1].compareTo(expected[1]) == 0);
    }
}

