package com.example;

import java.util.Scanner;
/* solutions to arrange horses in K  barns to come up with  minimum of whites*blacks
 * in all barns by Jung Verheiden */
public class horsearrange
{
    public static void main(String[]  args)
    {
        String horses = new String("WBWB");
        horsearrange obj = new horsearrange();
        System.out.println( obj.arrange(horses, 2) );
    }
    public int arrange(String a, int b) {
        int totalHorse = a.length();
        if ( totalHorse < b )
            return -1;
        return( (int) kArrange(a, 0, 0,  b) );
    }

    long kArrange(String a, int i, int k, int b)
    {
        int size = a.length();
        int numStable = b - k;
        int numHorses = size - i;
        int whites = 0;
        int blacks = 0;
        long min = Integer.MAX_VALUE;

        if ( numStable == numHorses )
              return 0;
        while( (i < size )  )
        {
            char c = a.charAt(i);
            i++;
            if ( c == 'W')
            {
                whites++;
                if ( blacks == 0 )
                {
                    while( ((size-i)  >  numStable) && ( a.charAt(i) == 'W'))
                    {
                        i++;
                        whites++;
                    }
                }
            }
            else
            {
                blacks++;
                if ( whites == 0 )
                {
                    while(((size-i)  > numStable) && ( a.charAt(i) == 'B'))
                    {
                        i++;
                        blacks++;
                    }
                }
            }
            if (k < ( b -1 ) && ( size - i ) >= (b-1))
                min   =  Math.min( kArrange(a, i, k+1, b) + whites*blacks, min);
            else if ( k ==( b -1 ) && ( i ==size ))
                min = whites*blacks;
        }
        return min;
    }
}
