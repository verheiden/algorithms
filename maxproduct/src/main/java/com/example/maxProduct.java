package com.example;

/*
** By Jung Verheiden, algorithm to compute a maximum possible production number
*  of a given array members.
*/
import java.util.ArrayList;
import java.util.List;

public class maxProduct {
    static public void main(String[] args){
       List<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(-1);
        a.add(0);
        a.add(2);
        a.add(3);
        a.add(0);
        a.add(-3);
        a.add(2);
        a.add(-3);
        a.add(0);
        a.add(-3);
        a.add(-1);
        a.add(0);

        maxProduct obj = new maxProduct();
        System.out.println(" maximum product  : " + obj.maxProduct(a));
    }
    public int maxProduct(final List<Integer> a) {

        if ( a == null ||  a.size() ==0 )
            return 0;
        int N = a.size();
        int i,iMax, iMin;

        int max = a.get(0);

        for ( i = 1, iMax = max, iMin = max;  i < N; i++)
        {
           if ( a.get(i) < 0 )
           {
               int temp = iMax;
               iMax = iMin;
               iMin = temp;
           }
            iMax = Math.max( a.get(i), iMax*a.get(i));
            iMin = Math.min( a.get(i), iMin*a.get(i));
            max = Math.max( max, iMax);
        }
        return max;
    }
}
