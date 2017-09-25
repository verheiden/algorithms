package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class minMax {

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();

        A.add(1);        A.add(4);        A.add(10);
        B.add(2);        B.add(15);        B.add(20);
        C.add(10);
        C.add(12);

        minMax obj = new minMax();
        int i = obj.minimize1(A, B, C);
    }

    public int minimize1(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int j;
        int k;
        int smallest=-1;
        for ( int i = 0; i < a.size(); i++)
        {
            int temp;
            j = findSmallestDiff( b, a.get(i) );
            k = findSmallestDiff( c, b.get(j) );
            int temp1 = Math.max( Math.abs(a.get(i) - b.get(j)), Math.abs(b.get(j) - c.get(k)));
            temp = Math.max( temp1,Math.abs(c.get(k) - a.get(i)));
            if ( smallest == -1 )
                smallest = temp;
            else
                smallest = Math.min( smallest, temp);
        }
        return smallest;
    }
    int findSmallestDiff( final List<Integer> aa, int value)
    {
        int low = 1;
        int high = aa.size() -1;
        int smallIndex = 0;
        int smallest = Math.abs(value - aa.get(0));
        while( low <= high )
        {
            int mid = (low + high)/2;
            if ( value > aa.get(mid))
            {
                if ( Math.abs(value - aa.get(mid)) < smallest)
                {
                    smallest =  Math.abs(value - aa.get(mid));
                    smallest = mid;
                }
                low = mid + 1;
            }
            else
            {
                if ( Math.abs(aa.get(mid)-value) < smallest)
                {
                    smallest = Math.abs(aa.get(mid)-value);
                    smallIndex = mid;
                }
                high = mid - 1;
            }
        }
        return smallIndex;
    }
}
