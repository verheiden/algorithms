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

    private static void sortBubble(int[] list)
    {
        int N = list.length;
        boolean swapped = true;
        for( int i = N-1; swapped == true && i>=1; i--)
        {
            swapped = false;
            for( int j = 0; j < i ; j++){
                if ( list[j] > list[j+1] ) {
                    swap(list, j, j + 1);
                    swapped = true;
                }
            }
        }
    }
    private static void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = data[i];
    }
}

