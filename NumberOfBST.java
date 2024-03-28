/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberofbst;

/**
 *
 * @author nayan
 */
public class NumberOfBST {

    public static long countBST(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; 
        long numberOfBSTs = countBST(n);
        System.out.println("Number of Binary Search Trees with " + n + " nodes: " + numberOfBSTs);
    }
}

