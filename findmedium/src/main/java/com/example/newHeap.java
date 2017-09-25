package com.example;

import java.util.Arrays;
/* solutions for heap sort and finding a median number of an array of numbers by Jung Verheiden */
public class newHeap {
    private static int nElement;
    private static int N;

    static void main(String[] args){
        int numbers[] = new int[] {9, 2000, 111, 4, 5 -10001, 20004, 5001, 4, 99, 123, 456 };
        System.out.println("Median number is "+ findMedian(numbers));

        nElement = numbers.length - 1;
    }
    static int findMedian(int[] numbers)
    {
        heapSort(numbers);
        int size = numbers.length/2;
        if ( ( size%2) == 0 )
        {
            return( (numbers[size-1] + numbers[size])/2 );
        }
        else
        {
            return numbers[size];
        }
    }

    static void heapify( int[] array){
        N = array.length - 1;
        for( int i = N/2; i >= 0; i --)
        {
            maxHeap1( array, i);
        }
    }
    static void maxHeap1( int[] array, int i)
    {
        int left = 2*i;
        int right = 2*i + 1;
        int largest = i;

        if ( (left<= N ) &&  array[largest] < array[left] )
        {
            largest = left;
        }
        if ((right<=N) && array[largest] < array[right])
        {
            largest = right;
        }
        if ( largest != i )
        {
            swap(array, i, largest);
            maxHeap1(array, largest);
        }
    }
    static void heapSort(int[] arrays)
    {
        buildHeap(arrays);

        for ( int i = nElement; i  > 0 ; i--)
        {
            swap(arrays, 0, i );
            nElement--;
            maxHeap(arrays, 0 );
        }
    }
    public static void swap(int[] arrays, int i, int j)
    {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
    public static void maxHeap(int[] arrays, int i){
        int left = 2*i;
        int right = 2*i + 1;
        int largest = i;
        if ( (left <= nElement ) && (arrays[left]>arrays[i]))
        {
            largest= left;
        }
        else
            largest = i;
        if ( (right <= nElement) && ( arrays[right] > arrays[largest]))
        {
            largest = right;
        }
        if ( largest != i)
        {
            swap(arrays, largest, i);
            maxHeap(arrays, largest);
        }

    }

    public static void buildHeap(int[] arrays)
    {
        nElement = arrays.length  -1 ;

        for ( int i = nElement/2; i >= 0; i--)
        {
            maxHeap(arrays, i);
        }

    }


}
