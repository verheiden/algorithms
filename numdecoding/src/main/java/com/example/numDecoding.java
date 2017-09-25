package com.example;

import java.util.Arrays;

public class numDecoding {
    int N;
    int[] dp;
    char[] st;
    public static void  main(String[] args)
    {
        numDecoding obj = new numDecoding();
        String a = new String("10");
        System.out.println(obj.numDecodings(a));
    }
    public int numDecodings(String a) {
        if ( a == null || a.length() == 0 )
            return 0;
        N = a.length();
        dp = new int[N];
        st = a.toCharArray();
        Arrays.fill(dp, -1);

        return ( decode(N-1));
    }
    int decode(int start)
    {
        int ways = 0;

        if ( start <  0 )
            return 1;

        if ( dp[start] != -1 )
            return dp[start];

        if ( st[start] > '0' )
            ways = decode( start -1  );


        if ( isTwoDigits(start) )
            ways += decode( start -2  );
        dp[start] = ways;
        return ways;
    }
    boolean isTwoDigits(int index)
    {
        if (  index  < 1 )
            return false;
        if ( (st[index-1] == '2' && st[index] <= '6' ) || (( st[index -1] == '1' ) && ( st[index] <= '9')))
            return true;
        else
            return false;
    }


}
