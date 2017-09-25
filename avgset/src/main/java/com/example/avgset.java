package com.example;

import java.util.ArrayList;
import java.util.Collections;

public class avgset
{
    ArrayList<ArrayList<Integer>> ans;
    int total;
    int N;
    ArrayList<Integer> A;
    ArrayList<Integer> res;
    boolean[][][] dp;
    public static void main(String[] args){
        ArrayList<Integer> numbs = new ArrayList<>();
        numbs.add(47);
        numbs.add(14);
        numbs.add(30);
        numbs.add(19);
        numbs.add(30);
        numbs.add(4);
        numbs.add(32);
        numbs.add(32);
        numbs.add(15);

        numbs.add(2);

        numbs.add(6);

        numbs.add(24);
        avgset obj = new avgset();
        obj.avgset(numbs);
    }
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a)
    {
        ans = new ArrayList<>();
        res = new ArrayList<Integer>();
        Collections.sort(a);
        N = a.size();
        A = a;
        total = 0;
        for(int i : a )
        {
            total += i;
        }
        dp = new boolean[N][total+1][N];
        for( int i = 0; i < N; i++)
        {
            for(int j = 0; j<= total; j++)
            {
                for(int k = 0; k< N; k++){
                    dp[i][j][k] = true;
                }
            }
        }
        for ( int size = 1; size < N; size++)
        {
            if ( ( total * size )%N == 0 )
            {
                int sumSet1 = (total*size)/N;
                if ( isPossible( 0, sumSet1, size ) )
                {
                    ans.add(res);
                    ans.add(buildOther(res));
                    return ans;
                }
            }
        }
        return ans;
    }

    boolean isPossible( int index, int sum, int size)
    {
        if ( size == 0 )
            return ( sum == 0 );
        if ( index >= N )
            return false;

        if ( sum <= 0 )
              return false;
        if ( dp[index][sum][size] == false )  return false;
        if ( sum >= A.get(index ))
        {
            res.add(A.get(index));
            if ( isPossible(index+1, sum - A.get(index), size -1 ))
            {
                return true;
            }
           res.remove( res.size() -1 );
        }
        if ( isPossible(index+1, sum, size )) return true;
        return dp[index][sum][size] = false;
    }

    ArrayList<Integer> buildOther(ArrayList<Integer> one)
    {
        ArrayList<Integer> B = new ArrayList<Integer>(A);
        for ( int num : one )
        {
            B.remove((Integer) num);
        }
        return B;
    }
}

