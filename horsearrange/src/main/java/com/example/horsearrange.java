package com.example;

import java.util.Scanner;
/* solutions to arrange horses in K  barns to come up with  minimum of whites*blacks
 * in all barns, there has to be at least one horse in all barns.  by Jung Verheiden */
public class horsearrange
{
    String horses;
    int size;
    int stables;
    public static void main(String[]  args)
    {
        String horses = new String("WBWBBBW");
        horsearrange obj = new horsearrange();
        System.out.println( obj.arrange(horses, 2) );
    }
    public int arrange(String a, int b) {
        horses = a;
        size = a.length();
        stables = b;
        if ( size < stables )
            return -1;
        return( (int) kArrange( 0, 0) );
    }

    long kArrange( int i, int usedStables)
    {
        int availStables = stables - usedStables;
        int numHorses = size - i;
        if ( availStables >  numHorses  )
            return 0;
        int whites = 0;
        int blacks = 0;
        long min = Integer.MAX_VALUE;
        usedStables++;
        if ( usedStables > stables )
              return 0;
        availStables = stables - usedStables;
        while ( i < ( size - availStables))
        {
            char c =horses.charAt(i);
            i++;
            if ( c == 'W')
            {
                whites++;
            }
            else {
                blacks++;
            }

            if ( usedStables < stables && (size -i) > (stables - usedStables )) {
                min = Math.min(kArrange(i, usedStables) + whites * blacks, min);
            }
        }
        min = Math.min( min, whites*blacks);
        return min;
    }
}
