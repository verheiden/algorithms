package com.example;

/*
** By Jung Verheiden, algorithm to compute a minimum distance between two number within
* a given array of numbers.
*/
import java.util.HashMap;

public class MinDistance {
    int minimum;
    public static void main(String[] args){
        int[]  input = new int[] {3,5,4,2,6,5,6,6,5,4,8,3};

        MinDistance obj = new MinDistance();
        System.out.println(obj.minDistance(input, 3, 6));
        int[] input2 = new int[] {2,5,3,5,4,4,2,3};
        System.out.println(obj.minDistance(input2, 3, 2));

    }
    int minDistance(int[] A,  int num1, int num2)
    {
        minimum = A.length - 1;
        int last1Index = -1;
        int last2Index = -1;
        for ( int i =0; i < A.length; i++ )
        {
            if ( A[i] == num1  )
            {

                if ( last2Index != -1 ){
                    if ( i - last2Index < minimum ){
                        minimum = i - last2Index;
                    }
                }
                last1Index = i;
            }
            else if ( A[i] == num2 )
            {
                if ( last1Index != -1 )
                {
                    if ( i - last1Index < minimum ){
                        minimum = i - last1Index;
                    }
                }
                last2Index = i;
            }
        }
        return minimum;
    }
}
