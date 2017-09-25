package com.example;

import java.util.Arrays;
/* Jung Verheiden's solution to the minimum numbers of cuts to make all the cuts to be a palindrone */
public class minCutsPalindrome
{
    static public void main(String[] args){
        //String a = new String("aabaacdeedcffjjkkkjjfflk");
        String a = new String("hellolle");
       minCutsPalindrome obj = new minCutsPalindrome();
       /* System.out.println(" MinCuts : " + obj.minCuts(a)); */

        int total = obj.countPalindrones(a);
        System.out.println("Total count : " + total );
    }
    String a;
    int N;
    int[] dp;
    boolean[][] isPalin;
    int minCuts(String a ) {
        if (a == null)
            return 0;
        if (a.length() == 1)
            return 0;
        N = a.length();
        isPalin = new boolean[N][N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            isPalin[i][i] = true;
            dp[i] = i;
        }

        for (int i = 1; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                if (a.charAt(i) == a.charAt(j) && ((i - j < 2) ||
                        isPalin[i - 1][j + 1])) {
                    if (j == 0)
                        dp[i] = 0;
                    else {
                        isPalin[i][j] = true;
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return (dp[N - 1]);
    }
    int countPalindrones(String a){
        int n = a.length();
        boolean[][] isPalin = new boolean[n][n];

        for ( int i = 0; i < n; i++)
        {
            isPalin[i][i] = true;
        }
        int count = 0;
        for ( int i = 0; i < n; i++){
            for ( int j = i; j>=0; j--)
            {
                if ( a.charAt(i) == a.charAt(j) && ((i -j < 2 )||  isPalin[i-1][j+1] == true  ))
                {
                    isPalin[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}


