package main;

import algorithms.MathUtil;
import algorithms.QuadraticSieve;

import java.math.BigInteger;

/**
 * Main class for executing custom inputs
 */
public class Main {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("539873");
        //QuadraticSieve.factorize(n);
        System.out.println(MathUtil.getFactorBase(17));
    }
}
