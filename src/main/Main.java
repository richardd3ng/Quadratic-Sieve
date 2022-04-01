package main;

import algorithms.MathUtil;
import algorithms.QuadraticSieve;

import java.math.BigInteger;
import java.util.List;

/**
 * Main class for executing custom inputs
 */
public class Main {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("539873");
        //QuadraticSieve.factorize(n);
        List<Integer> primes = MathUtil.getFactorBase(10000);
        for (Integer i : primes) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("number of primes: " + primes.size());
    }
}
