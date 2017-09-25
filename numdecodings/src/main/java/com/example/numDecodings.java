package com.example;

import java.util.Arrays;
/* Jung Verheiden's solution to determine number of ways to decode an integer into ABC titles */
public class numDecodings {
    int[] dp;
    int N;
    String a;
    static public void main(String[] args){
        String a = new String("875361268549483279131");
        numDecodings obj = new numDecodings();
        System.out.println(" number of decoing ways  : " + obj.numDecodings(a));
    }
    public int numDecodings(String a) {
        if ( a == null || a.length() == 0 )
            return 0;
        this.a = a;
        N = a.length();
        dp = new int[N];
        Arrays.fill(dp, -1);
        return( ways(0));
    }
    int ways(int index)
    {
        int diffWays = 0;
        if ( index == N )
            return 1;
        if ( !isDigit(a.charAt(index)))
            return 0;
        if ( dp[index] != -1 )
            return dp[index];

        if ( isDigit( a.charAt(index)))
        {
            diffWays  +=  ways(index+1);
        }
        if ( isValid(index) )
            diffWays +=  ways( index+2 );

        dp[index] = diffWays;
        return dp[index];



    }
    boolean isValid(int index)
    {
        if ( (index <=  N-2) )
        {
            int num = (int) ( a.charAt(index) - '0' ) *10;
            num += (int) (a.charAt(index+1) - '0');
            if ( num >=10 &&  num <= 26 )
                return true;
        }
        return false;
    }
    boolean isDigit(char c)
    {
        if ( c >= '1' && c <= '9' )
            return true;

        else
            return false;
    }}
