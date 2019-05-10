package com.example;

import java.util.ArrayList;

public class minMaxBooks {

    public static void main(String[] args){
        ArrayList<Integer>  pages = new ArrayList<Integer>();

        pages.add(12);
        pages.add(34);
        pages.add(67);
        pages.add(90);
        minMaxBooks obj = new minMaxBooks();
        System.out.println(obj.books( pages, 2));

    }
    public int books(ArrayList<Integer> a, int b)
    {
        long n = a.size();
        if ( b > n )
            return -1;


        long low = 0;
        long res = -1;

        long total =0;
        for( int nn : a )
        {
            total += nn;
        }
        long  high = total;
        while ( low <= high )
        {
            long  mid = low + ( high - low )/2;
            if ( isAllocatable( a, b,total, mid))
            {
                res = mid;
                high   = mid - 1 ;
            }
            else
            {
                low = mid +1 ;
            }
        }
        return ((int) res);
    }

    boolean isAllocatable( ArrayList<Integer> a, int b, long  total, long max)
    {
        int index = 0;
        int n = a.size();
        if ( (total/n ) >  max )
            return false;

        for(int i = 0; i <b  && ( index < n ) ; i++)
        {
            long  sum = 0;
            while( (index <n) && (sum < max ))
            {
                sum += a.get(index);
                if ( sum > max )
                {
                    break;
                }
                index++;
            }
        }
        if (( index == n ) )
            return true;
        else
            return false;
    }
}

