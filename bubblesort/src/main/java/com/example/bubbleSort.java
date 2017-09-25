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
        boolean swapped = true;
        int n = list.length;
        for(int pass = n-1; ( pass>0 && swapped ); pass--)
        {
            for(int i = 0; i < pass; i++){
                swapped = false;
                if ( list[i] > list[i+1]){
                    swapped  = true;
                    int temp = list[i+1];
                    list[i+1] = list[i];
                    list[i] = temp;
                }
            }
        }
    }
}

