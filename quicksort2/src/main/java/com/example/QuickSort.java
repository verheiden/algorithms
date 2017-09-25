package com.example;
/* Quicksort algorithm by Jung Verheiden */
public class QuickSort {
    static final int[] arrays  =  { 98, 123, 456, -1, -11, -333, 789, 1234, -3, 77 };
    static public void main(String[]  args){
        quickSort(arrays, 0, 9);
        System.out.println("\nQuickSort : ");
        for(int n : arrays ){
            System.out.print(" " + n );
        }
    }

    static private void quickSort(int[] arrays, int low, int high)
    {
         int pivot = arrays[(low + high)/2];
         int i = low;
         int j = high;
         while(i <= j )
         {
              while(arrays[i] < pivot ){
                  i++;
              }
              while(arrays[j] > pivot ){
                  j--;
              }
             if ( i <= j )
             {
                 swap(arrays, i, j);
                 i++;
                 j--;
             }
         }
        if ( j > low )
        {
            quickSort(arrays, low, j);
        }
        if ( i < high ){
            quickSort(arrays, i, high);
        }
    }
    private static void swap(int[] arrays, int i, int j)
    {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }
}