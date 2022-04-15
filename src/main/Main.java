package main;

import algorithms.MathUtil;
import algorithms.QuadraticSieve;

import java.math.BigInteger;

/**
 * Main class for executing custom inputs
 */
public class Main {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("521900076822691495534066493");
        BigInteger[] results = QuadraticSieve.factorize(n);
        System.out.println(results[0]);
        System.out.println(results[1]);
    }
}
