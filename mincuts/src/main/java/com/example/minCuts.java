package com.example;

import java.util.Arrays;
/* solution to find a minimum numbers of cuts to cut out all the palindrome substrings
 * by Jung Verheiden
 */
public class minCuts {
    boolean[][] isPalin;
    int[] dp;
    String a;
    int N;
    public static void main(String[] args)
    {
        String a = new String("abcbaddeffe");
        //String a = new String("ababb");
        minCuts obj = new minCuts();
        System.out.println(obj.minCut(a));
    }
    public int minCut(String a) {
        int i, j, l;
        try
        {
            N = a.length();
            if (N <= 1)
                return N;
            isPalin = new boolean[N][N];
            for (i = 0; i < N; i++) {
                Arrays.fill(isPalin[i], false);
            }
            dp = new int[N];
            for (i = 0; i < N; i++) {
                dp[i] = i;
                isPalin[i][i] = true;
            }
        } catch ( Exception e )
        {
            System.out.println(" Exception" + e);
        }
        for( l = 2; l <= N; l++)
        {
            for ( i = 0; i < N -l +1; i++)
            {
                j = i+l-1;
                if ( l== 2)
                {
                    isPalin[i][j] = a.charAt(i) == a.charAt(j);
                }
                else
                {
                    isPalin[i][j] = (a.charAt(i) == a.charAt(j) ) && ( isPalin[i+1][j-1]);
                }
            }
        }
        for ( i = 0; i < N; ++i)
        {
            if ( isPalin[0][i] )
                dp[i] = 0;
            else
            {
                dp[i]= Integer.MAX_VALUE;
                for ( j = 0; j < i; j++)
                {
                    if ((isPalin[j+1][i] ) &&( ( 1+dp[j]) < dp[i]))
                        dp[i] = 1+dp[j];
                }
            }
        }
        return ( dp[N-1] );
    }
}
