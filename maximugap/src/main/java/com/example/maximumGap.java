package com.example;

import java.util.ArrayList;
import java.util.List;
/* solutions to find maximum gap by Jung Verheiden */
public class maximumGap {

    public static void main(String[] args)
    {
        maximumGap obj = new maximumGap();
        ArrayList<Integer> A = new ArrayList<Integer>();
 /*       A.add(3);
        A.add(2);
        A.add(1);
        int i = obj.maximumGap(A);
        System.out.println(i); */

        A.add((int)'9');
        A.add((int)'9');
        A.add((int)'9');
        A.add((int)'9');
        A.add((int)'9');
        ArrayList a= obj.plusOne(A);
        System.out.println("End");
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        boolean precedingZero = true;
        int n = a.size();
        ArrayList<Integer> output = new ArrayList<Integer> ();
        for (int i = 0; i < a.size() -1; i++)
        {
            if ( ( precedingZero == true) )
            {
                if ( a.get(i)=='0')
                    continue;
                else
                {
                    precedingZero = false;
                }
            }
            output.add(a.get(i));
        }

        int c = a.get(n-1);
        if( c != '9' )
        {
            output.add(c + 1 );
            return output;
        }
        else //if ( c == '9')
        {
            output.add((int) '0');
            int prev = a.size() - 2;;
            while( c ==  '9') {
                if (prev <= -1) {
                    output.add(0, (int) '1');
                    return output;
                } else if (a.get(prev) != '9') {
                    output.set(prev, a.get(prev) + 1);
                    return output;
                } else {
                    output.set(prev, (int)'0');
                    prev--;
                    if ( prev >= 0 )
                        c = a.get(prev);
                }
            }
        }
        return output;
    }
    public int maximumGap(final List<Integer> a)
    {
        int furtherest = -1;
        int n = a.size();
        int[] minLeft = new int[n];
        int[] maxRight = new int[n];
        minLeft[0] = a.get(0);
        for( int j = 1; j < n; j++)
        {
            minLeft[j] = Math.min(minLeft[j-1], a.get(j));
        }
        maxRight[n-1] = a.get(n-1);
        for ( int k = n -2 ; k >= 0; k--)
        {
            maxRight[k] = Math.max(maxRight[k+1], a.get(k));
        }

        for (int i = n -1; i >= 0; i--){
            int num = maxRight[i];
            int m = minIndex( minLeft, num );
            furtherest = Math.max( furtherest, i - m );
        }
        return(furtherest);
    }
    int minIndex(int[] minLeft, int num)
    {
        int low = 0;
        int high = minLeft.length;
        int mid = 0;
        int index = -1;
        while( low <= high )
        {
            mid = (low + high)/2;
            if ( num < minLeft[mid] )
            {
                low = mid +1;
            }
            else
            {
                high = mid -1;
                index = mid;
            }
        }
        return index;
    }

}
