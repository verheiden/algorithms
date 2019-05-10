package com.example;


import java.util.Scanner;
/* solutions for binary tree by Jung Verheiden */

public class bubbleSort {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] arrays = {7,2000,-3001,222, 3333, -4444, 5555, 6066, 10111, 6, 7, 8, 9};
        sortBubble(arrays);
        for (int j: arrays)
        {
            System.out.print(j);
            System.out.print(" ");
        }
    }
public static void sortBubble(int[] arrays){
        int N = arrays.length;
        boolean swapped = true;
        for ( int i = N-1; swapped == true && i > 0; i--){
            swapped = false;
            for ( int j = 0; j < i; j++){
                if ( arrays[j] > arrays[j+1]){
                    swapped = true;
                    swap(arrays, j, j+1);
                }
            }
        }
}
    private static void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

