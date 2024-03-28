/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primenumbersrange;

/**
 *
 * @author nayan
 */
public class PrimeNumbersRange {
    public static void main(String[] args) {
        int[][] primeRanges = findPrimeNumbersInRange(0, 1000, 100);
        displayPrimeRanges(primeRanges);
    }

    public static int[][] findPrimeNumbersInRange(int start, int end, int rangeSize) {
        int numRanges = (end - start) / rangeSize + 1;
        int[][] primeRanges = new int[numRanges][];

        for (int i = 0; i < numRanges; i++) {
            int rangeStart = start + i * rangeSize;
            int rangeEnd = rangeStart + rangeSize - 1;
            primeRanges[i] = findPrimesInRange(rangeStart, rangeEnd);
        }

        return primeRanges;
    }

    public static int[] findPrimesInRange(int start, int end) {
        int[] primes = new int[end - start + 1];
        int primeIndex = 0;

        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                primes[primeIndex++] = num;
            }
        }

        // Trim array to actual size
        int[] trimmedPrimes = new int[primeIndex];
        System.arraycopy(primes, 0, trimmedPrimes, 0, primeIndex);
        return trimmedPrimes;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void displayPrimeRanges(int[][] primeRanges) {
        for (int i = 0; i < primeRanges.length; i++) {
            int start = i * 100;
            int end = start + 99;
            System.out.println("Prime numbers in range " + start + " - " + end + ":");
            for (int prime : primeRanges[i]) {
                if (prime != 0) {
                    System.out.print(prime + " ");
                }
            }
            System.out.println();
        }
    }
}

