package com.example;

/*
** By Jung Verheiden, algorithm to find out a maximum coins possible to collect
*  given two person takes a coin either a right send ide or a left beginning  side
*  from a given array of a different denomination coins.
*/
import java.util.ArrayList;
import java.util.Arrays;

public class maxCoin {
    ArrayList<Integer> a;
    int[][][] dp;
    static public void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        maxCoin obj = new maxCoin();
        System.out.println("Max coin one can win  : " + obj.maxcoin(a));
    }
    public int maxcoin(ArrayList<Integer> a) {
        int N = a.size();
        this.a = a;
        dp = new int[2][N][N];
        for ( int i = 0; i < N; i++ )
        {
            Arrays.fill(dp[0][i], -1 );
            Arrays.fill(dp[1][i], -1 );
        }
        int ans = recv(0, 0, N-1);
        return ans;
    }

    int recv(int player, int left, int right)
    {
        if ( left >  right )
            return 0;
        if ( dp[player][left][right] != -1 )
            return dp[player][left][right];
        int ans;
        if ( player == 0 )
        {
            ans  = a.get(left) + recv(1, left+1, right);
            ans  =  Math.max( ans, a.get(right) + recv(1, left, right-1));
        }else
        {
            ans =  recv(0, left+1, right);
            ans = Math.min(ans,  recv(0, left, right-1));
        }
        return dp[player][left][right] = ans;
    }
}
