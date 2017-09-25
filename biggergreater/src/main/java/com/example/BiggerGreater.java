package com.example;

import java.util.Arrays;
import java.util.Scanner;
/* solutions for binary tree by Jung Verheiden */
public class BiggerGreater {
    static final int NUM_ALPHABET = 27;

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();

        while (T-- > 0) {
            String s = reader.next();
            System.out.println(BiggerGreater(s));
        }
    }

    static String BiggerGreater(String is) {
        char[] newString = is.toCharArray();
        boolean charFound = false;
        int len = newString.length;
        int ic, bigger, iiBigger;


        for (int i = 0; i < len  - 1 ; i++)
        {
            char c = newString[i];
            char cii = newString[i + 1];
            char cj;
            ic = i + 1 ;
            iiBigger = bigger = 0;
            for (int j = i +1; j < len ;  j++) {
                cj = newString[j];
                    if (cj > c) {
                        bigger++;
                        if (cj < newString[ic])
                            ic = j;

                        if ( cj > cii )
                            iiBigger++;
                    }
            }
           if (( iiBigger == 0 ) && ( bigger > 0 ))
            {
                    swap(newString, i, ic);
                    if ( i < ( len - 2 ) )
                        quicksort(newString, i +1 , len -1 );
                    return(new String(newString));
            }
        }
        return(new String("no answer"));
    }

    static void swap(char[] array, int i, int j)
    {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private static void  quicksort(char[] numbers, int low, int high)
    {
        if ( low < high )
        {
            int index = partition(numbers, low, high);
            quicksort(numbers, low, index - 1);
            quicksort(numbers, index +1, high);
        }
    }
    static int partition(char[] input, int low, int high)
    {
        int pivot = input[high];
        int i = low;
        for(int j = low; j <  high   ; j++)
        {
            if ( input[j] <=  pivot ){
                swap(input,i, j );
                i++;
            }
        }
        swap(input, i, high);
        return  i;
    }
}
