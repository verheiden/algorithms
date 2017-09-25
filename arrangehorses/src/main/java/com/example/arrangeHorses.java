package com.example;

import java.util.Arrays;
/*
**by Jung Verheiden, arrange horses in black and white to possible minimum of
* *  of multiplication of the white and black horeses.
*/

public class arrangeHorses {
    static public void main(String[] args){
        String a = new String("WBWB");
        arrangeHorses obj = new arrangeHorses();
        System.out.println(" Arrangement horeses : " + obj.arrange(a,2));
    }

    String a;
    int N;
    int b;
    int[][] dp;
    public int arrange(String a, int b) {
        this.a = a;
        this.b = b;
        if ( a == null || a.length() == 0 )
            return 0;
        N = a.length();
        dp = new int[N][b];
        for (int i =0; i < N; i++)
        {
            Arrays.fill(dp[i], -1 );
        }
        int ans = recr(0, 0 );
        if ( ans == Integer.MAX_VALUE )
        {
            ans = -1;
        }
        return ans;
    }

    int recr(int horse,  int stable)
    {
        int white = 0, black = 0;
        if ( horse == N )
        {
            if ( stable == b )
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        if ( stable == b)
            return Integer.MAX_VALUE;

        if  ( dp[horse][stable]  != -1 )
            return( dp[horse][stable]);

        int ans = Integer.MAX_VALUE;
        for ( int i = horse; i < N; i++)
        {
            if ( a.charAt(i) == 'W')
                white++;
            else if ( a.charAt(i) == 'B')
                black++;
            if (  white*black > ans  )
                break;
            int temp = recr(i+1, stable +1 );
            if ( temp != Integer.MAX_VALUE )
            {
                ans = Math.min(ans, temp + white*black);
            }
        }
        return dp[horse][stable] = ans;
    }
}
