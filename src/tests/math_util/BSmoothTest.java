package tests.math_util;

import algorithms.MathUtil;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BSmoothTest {

    @Test
    void test1620() {
        BigInteger n = new BigInteger(String.valueOf(1620));
        List<Integer> factorBase = List.of(2, 3, 5);
        boolean expected = true;
        testIsBSmooth(n, MathUtil.computeListProduct(factorBase), expected);
    }

    @Test
    void test736Squared() {
        BigInteger n = new BigInteger(String.valueOf(736*736));
        List<Integer> factorBase = List.of(2, 3, 5, 7, 11, 13, 17);
        boolean expected = false;
        testIsBSmooth(n, MathUtil.computeListProduct(factorBase), expected);
    }

    @Test
    void test735Squared() {
        BigInteger n = new BigInteger(String.valueOf(735*735));
        List<Integer> factorBase = List.of(2, 3, 5, 7, 11, 13, 17);
        boolean expected = true;
        testIsBSmooth(n, MathUtil.computeListProduct(factorBase), expected);
    }

    private void testIsBSmooth(BigInteger n, BigInteger factorBaseProduct, boolean expected) {
        assertEquals(expected, MathUtil.isBSmooth(n, factorBaseProduct));
    }
}
