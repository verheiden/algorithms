package com.example;

import java.util.ArrayList;
import java.util.Collections;

public class sumZero
{


    boolean sumZero(ArrayList<Integer> A)
    {
        if ( A.size() < 3 )
            return false;
        int N = A.size();
        Collections.sort(A);

        for ( int i = 0; i < A.size() -2; i++)
        {
            int j = i+1;
            int k = N -1;
            long sum;
            while(j < k )
            {
                sum = A.get(i) + A.get(j) + A.get(k);
                if ( sum == 0 )
                    return true;
                else if ( sum < 0 )
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return false;
    }
}
