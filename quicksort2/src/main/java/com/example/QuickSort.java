package com.example;
/* Quicksort algorithm by Jung Verheiden */
public class QuickSort {
    static final int[] arrays  =  { 98, 123, 456, -1, -11, -333, 789, 1234, -3, 77 };
    static public void main(String[]  args){
        quickSort(arrays, 0, arrays.length -1);
        System.out.println("\nQuickSort : ");
        for(int n : arrays ){
            System.out.print(" " + n );
        }
    }

    static void quickSort(int[] data, int start, int end)
    {
        int pivot = data[( start  + end )/2];
        int i = start;
        int j = end;

        while( i <=  j)
        {
            while( data[i] < pivot )
            {
                i++;
            }
            while( data[j] > pivot )
            {
                j--;
            }
            if ( i <= j ) {
                swap(data, i, j);
                i++;
                j--;
            }
        }
        if ( j > start )
            quickSort(data, start, j);
        if ( i < end )
            quickSort(data, i, end);

    }
    static void swap(int[] data, int i , int j )
    {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}