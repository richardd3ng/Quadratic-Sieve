package main;

import algorithms.EuclideanAlgorithm;

import java.math.BigInteger;

/**
 * Main class for executing custom inputs
 */
public class Main {

    public static void main(String[] args) {
        String int1 = "27", int2 = "900";
        BigInteger a = new BigInteger(int1), b = new BigInteger(int2);
        System.out.println(EuclideanAlgorithm.gcd(a, b));
    }
}
