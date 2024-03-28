/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primenumberanagram;

/**
 *
 * @author nayan
 */
import java.util.*;

public class PrimeNumberAnagram {
    public static void main(String[] args) {
        int[][] primeAnagramRanges = findPrimeAnagramsInRange(0, 1000, 100);
        displayPrimeAnagramRanges(primeAnagramRanges);
    }

    public static int[][] findPrimeAnagramsInRange(int start, int end, int rangeSize) {
        int numRanges = (end - start) / rangeSize + 1;
        int[][] primeAnagramRanges = new int[numRanges][];
        
        for (int i = 0; i < numRanges; i++) {
            int rangeStart = start + i * rangeSize;
            int rangeEnd = rangeStart + rangeSize - 1;
            primeAnagramRanges[i] = findPrimeAnagramsInRange(rangeStart, rangeEnd);
        }

        return primeAnagramRanges;
    }

    public static int[] findPrimeAnagramsInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isPrime(num) && isAnagram(start, num)) {
                primes.add(num);
            }
        }

        int[] result = new int[primes.size()];
        for (int i = 0; i < primes.size(); i++) {
            result[i] = primes.get(i);
        }
        return result;
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

    public static boolean isAnagram(int num1, int num2) {
        char[] num1Chars = String.valueOf(num1).toCharArray();
        char[] num2Chars = String.valueOf(num2).toCharArray();
        Arrays.sort(num1Chars);
        Arrays.sort(num2Chars);
        return Arrays.equals(num1Chars, num2Chars);
    }

    public static void displayPrimeAnagramRanges(int[][] primeAnagramRanges) {
        for (int i = 0; i < primeAnagramRanges.length; i++) {
            int start = i * 100;
            int end = start + 99;
            System.out.println("Prime Anagrams in range " + start + " - " + end + ":");
            for (int prime : primeAnagramRanges[i]) {
                if (prime != 0) {
                    System.out.print(prime + " ");
                }
            }
            System.out.println();
        }
    }
}

