package com.example;

import java.util.Scanner;
/* Shell sort and Insertion sort solution  by Jung Verheiden */
public class FastInsertion
{
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        int[] s = new int[T];

       for(int i = 0; i < T; i++){
            s[i] = stdin.nextInt();
        }
       shellSort(s);

    }
    public static void shellSort(int[] input) {
        int temp = 0;
        int i, j;

        for (int gap = input.length / 2; gap > 0; gap = gap / 2) {
            for (i = gap; i < input.length; i++) {
                temp = input[i];
                for (j = i; (j >= gap) && (input[j - gap] > temp); j -= gap) {
                    input[j] = input[j - gap];
                }
                input[j] = temp;
            }
        }
    }
    public static void insertionSort(int[] input)
    {
        int n = input.length;

        for ( int i = 1; i < n; i++){
            int temp = input[i];
            int j = i -1;

            while ( j>=0 && ( input[j] > temp ))
            {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = temp;
        }
    }

    public static void shellSort1(int[] input)
    {
        int n = input.length;
        for(int gap = n/2;  gap >= 0;  gap /= 2){

            for ( int i = gap;  i <n;  i++){

                int key = input[i];
                int j;
                for(  j = i;  ( j >= gap ) && ( input[j - gap ] > key ); j -= gap )
                {
                    input[j] = input[j - gap];
                }
                input[j] = key;
            }
        }
    }

}
