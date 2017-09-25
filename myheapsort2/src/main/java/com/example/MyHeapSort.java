package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class MyHeapSort {
/*
 * Read in integer numbers from the standard input and sort them using heap sort
 * algorithm by Jung Verheiden.
 */
    public static void main(String[] args )
    {
        ArrayList<Integer> numbers;
        Scanner reader = new Scanner(System.in);
        numbers = new ArrayList<Integer>();
        int n = reader.nextInt();
        int[] arrays = new int[n];
        for(int i =0; i < n; i++){
            arrays[i] = reader.nextInt();
        }
        heapSort(arrays);
        System.out.println("The sorted output ");
        for(int i = 0; i<n; i++){
            System.out.println(arrays[i]);
        }
    }

    static private void heapSort(int[] arrays)
    {
           int n = arrays.length;
           heapify(arrays, n);

          for ( int i = n -1; i >= 0; i-- )
          {
              swap( arrays, 0, i);
              maxHeap(arrays, 0, i-1);
          }
    }

    static private void heapify(int[] arrays, int size)
    {
        int index = size -1;
        if ( index <= 0 )
            return;
        for(int i = index/2; i>= 0;i--){
            maxHeap(arrays, i, size);
        }
    }    

    static private void swap(int[] arrays, int i,  int j){
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }
    
    static private void maxHeap(int[] arrays, int i, int size)
    {
        int left = 2*i;
        int right = 2*i + 1;
        int largest = i;
        if ( (left <= size ) && ( arrays[left] > arrays[i]))
        {
            largest = left;
        }
        if ( (right <= size) && ( arrays[right]>arrays[largest]))
        {
            largest = right;
        }
        if ( largest != i)
        {
            swap(arrays, i, largest);
            maxHeap(arrays, largest, size);
        }
    }    
}
