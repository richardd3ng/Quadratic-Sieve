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

    // the bottom 4 numbers are the examples from the document
    @Test
    void test_16921456439215439701() {
        BigInteger n = new BigInteger("16921456439215439701");
        BigInteger factor1 = new BigInteger("2860486313");
        BigInteger factor2 = new BigInteger("5915587277");
        testQuadraticSieve(n, new BigInteger[]{factor1, factor2});
    }

    @Test
    void test_46839566299936919234246726809() {
        BigInteger n = new BigInteger("46839566299936919234246726809");
        BigInteger factor1 = new BigInteger("100000000105583");
        BigInteger factor2 = new BigInteger("468395662504823");
        testQuadraticSieve(n, new BigInteger[]{factor1, factor2});
    }

    // the last 2 currently take forever cuz factor base is too small

    @Test
    void test_6172835808641975203638304919691358469663() {
        BigInteger n = new BigInteger("6172835808641975203638304919691358469663");
        BigInteger factor1 = new BigInteger("11111111111111111011");
        BigInteger factor2 = new BigInteger("555555222777777773333");
        testQuadraticSieve(n, new BigInteger[]{factor1, factor2});
    }

    @Test
    void test_3744843080529615909019181510330554205500926021947() {
        BigInteger n = new BigInteger("3744843080529615909019181510330554205500926021947");
        BigInteger factor1 = new BigInteger("1123456667890987666543211");
        BigInteger factor2 = new BigInteger("3333322225555555777777777");
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

