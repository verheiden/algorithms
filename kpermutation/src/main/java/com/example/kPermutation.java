package com.example;

import java.util.ArrayList;
/* solutions for kth permutations of a number  by Jung Verheiden */
public class kPermutation {
    public static void main(String[] args)
    {
        kPermutation obj = new kPermutation();

       String abc = obj.getPermutation(2, 2);
        System.out.println(abc);
        System.out.println(obj.trailingZeroes(9247));
    }
    public int trailingZeroes(int a) {

        int trailingZero = 0;
        int tens = a;
        while( tens > 5  )
        {
            trailingZero += tens/5;
            tens /= 5;
        }

        return( trailingZero);
    }
    public String getPermutation(int n, int k)
    {
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        if ( n == 0 )
            return( new String());

        for ( int i = 1 ; i <= n; i++)
            candidates.add(i);
        return(getPermutations(k-1, candidates) );
    }

    String  getPermutations(int k, ArrayList<Integer> candidates)
    {
        int n = candidates.size();
        if ( n <= 0 )
            return "";
        if ( k  > factorial(n)  )
            return "";
        int fn = factorial(n-1);
        int pos = k/fn   ;
        String digits = digits(candidates.get(pos));
        k = k%fn;
        candidates.remove(pos);

        return( digits  + getPermutations(k, candidates));
    }

    String digits(int num)
    {
        StringBuffer buffer = new StringBuffer();

        while(num>0)
        {
            char c = (char) ( ( num%10 )+'0' );
            num  /= 10;
            buffer.insert(0,c);
        }
        return buffer.toString();
    }
    int factorial(int n)
    {
        int fac = 1;
        if ( n == 0 )
              return 0;
        if ( n == 1)
            return  1;
        if ( n > 12 )
            return Integer.MAX_VALUE;

        for ( int i =2; i<=n; i++)
        {
            fac *= i;
        }
        return fac;
    }
}
