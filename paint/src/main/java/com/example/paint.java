package com.example;

import java.util.ArrayList;
/* solution algorithm by Jung Verheiden to find the minimum time to paint entire boards */
public class paint {
    final static  long MOD = 10000003;
    ArrayList<Integer> c;
    int painters;
    int time;
    long max_element;
    static public void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
      paint obj = new paint();
        a.add(1);
        a.add(10);
        int num = obj.paint(2, 5, a);
        System.out.println( " " + num + " ");
    }
    public int paint(int a, int b, ArrayList<Integer> c) {
        long mid = Integer.MAX_VALUE;
        long low = 0;
        long high = 0;
        int n = c.size();
        long res = Integer.MAX_VALUE;
        this.c = c;
        painters = a;
        max_element  = c.get(0);
        for (int i = 0; i < n; i++ )
        {
            high += c.get(i);
            if ( max_element < c.get(i))
                max_element = c.get(i);
        }
        while( low <= high )
        {
            mid = ( low + high )/2 ;
            boolean status = isPossible(mid );
            if ( status )
            {
                high = mid - 1;
                res = Math.min( res, mid);
            }
            else
            {
                low  = mid +1;
            }
        }
        return(( int )((res*b) %MOD ));
    }

    boolean isPossible( long totalTime )
    {
        long sum = 0;
        int cnt = 1;

        if ( totalTime < max_element )
            return false;

        for( int i = 0; i < c.size();)
        {
            sum += (1L)*c.get(i);
            if ( sum > totalTime)
            {
                sum = 0;
                cnt++;
                if ( cnt > painters )
                    return false;
            }
            else
                i++;
        }
        if ( cnt <= painters )
            return true;
        else
            return false;
    }   
}
