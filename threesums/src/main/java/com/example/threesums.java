package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class threesums {
    public static void main(String[] args)
    {
         threesums obj = new threesums();
        int[]   abc = new int[] { 1, -2, 2, 4, -1, 5};
        if ( obj.threesumsZero(abc))
        {
            System.out.println("Yes");
        }
        else
            System.out.println("No");
    }
    boolean threesumsZero(int[] numbers)
    {
        java.util.Arrays.sort(numbers);
        int n = numbers.length;
       for ( int i = 0; i < n - 2; i++)
       {
           int j = i+1;
           int k = n-1;
           while( j < k )
           {
               long sums = numbers[i] + numbers[j] + numbers[k];
               if ( sums == 0 )
                   return true;
               else if ( sums < 0 )
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
