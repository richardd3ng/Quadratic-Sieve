package tests;
import Algorithms.EuclideanAlgorithm;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

public class EuclideanAlgorithmTest {

    @Test
    void test0_0() {
        BigInteger a = BigInteger.ZERO, b = BigInteger.ZERO, expected = BigInteger.ZERO;
        testGCD(a, b, expected);
    }

    @Test
    void test1_0() {
        BigInteger a = BigInteger.ONE, b = BigInteger.ZERO, expected = BigInteger.ONE;
        testGCD(a, b, expected);
    }

    @Test
    void test5_10() {
        BigInteger a = new BigInteger("5"), b = new BigInteger("10"), expected = new BigInteger("5");
        testGCD(a, b, expected);
    }

    @Test
    void test1_1() {
        BigInteger a = new BigInteger("1"), b = new BigInteger("1"), expected = new BigInteger("1");
        testGCD(a, b, expected);
    }

    @Test
    void test121_23() {
        BigInteger a = new BigInteger("123"), b = new BigInteger("23"), expected = new BigInteger("1");
        testGCD(a, b, expected);
    }

    @Test
    void test1001_169() {
        BigInteger a = new BigInteger("169"), b = new BigInteger("1001"), expected = new BigInteger("13");
        testGCD(a, b, expected);
    }

    @Test
    void test_neg_1001_169() {
        BigInteger a = new BigInteger("-169"), b = new BigInteger("1001"), expected = new BigInteger("13");
        testGCD(a, b, expected);
    }

    @Test
    void testBigNumber1() {
        BigInteger a = new BigInteger("96884638240"), b = new BigInteger("642401"), expected = new BigInteger("1129");
        testGCD(a, b, expected);
    }

    @Test
    void testNegBigNumber1() {
        BigInteger a = new BigInteger("-96884638240"), b = new BigInteger("642401"), expected = new BigInteger("1129");
        testGCD(a, b, expected);
    }

    @Test
    void testBigNumber2() {
        BigInteger a = new BigInteger("3744843080529615909019181510330554205500926021947"), b = BigInteger.ONE, expected = BigInteger.ONE;
        testGCD(a, b, expected);
    }

    /**
     * Utility function for testing EuclideanAlgorithm.gcd()
     * @param a the first integer
     * @param b the second integer
     * @param expected the expected result of gcd(a, b)
     */
    private void testGCD(BigInteger a, BigInteger b, BigInteger expected) {
        assertEquals(expected, EuclideanAlgorithm.gcd(a, b));
    }
}
