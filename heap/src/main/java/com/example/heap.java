package com.example;
/* solutions for binary tree by Jung Verheiden */
public class heap {
    static int[] numbers = {  -1, 23456, -11, 23456, -111, 0, 456, 789, 1 ,4 ,8, -99 };
    static int[] numbers1 = {  -1, 23456, -11, 23456, -111, 0, 456, 789, 1 ,4 ,8, -99 };
    static int Size;
    static public void main(String[] args){

        heapSort1(numbers);
        System.out.println("\nHeap sorted array\n");
        for(int i : numbers ){
            System.out.print(" " + i);
        }

        quickSort(numbers1, 0, numbers1.length-1);
        System.out.println("\nQuick sorted array\n");
        for(int i : numbers ){
            System.out.print(" " + i);
        }
    }

    static void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    static int Total ;
    static void heapSort1(int[] data){
        Total = data.length - 1;
        heapify1(data);

        while( Total > 0 )
        {
            swap(data, 0, Total);
            Total--;
            maxHeap1(data, 0);
        }
    }
    static void maxHeap1(int[] data, int parent){
        int left = parent*2;
        int right = left + 1;
        int largest = parent;
        if ( left <= Total &&  data[largest] < data[left])
            largest = left;
        if ( right <= Total && data[largest] < data[right] )
            largest = right;
        if ( largest != parent ) {
            swap(data, parent, largest);
            maxHeap1(data, largest);
        }
    }
    static void heapify1(int[] data){
        for( int i = Total/2; i >= 0; i--)
        {
            maxHeap1(data, i);
        }
    }

    static private void quickSort(int[] arrays, int low, int high)
    {
        int pivot = arrays[(low+high)/2];
        int i = low;
        int j = high;
        while( i <= j )
        {
            while( arrays[i] < pivot )
                i++;
            while(arrays[j] > pivot )
                j--;
            if ( i <= j )
            {
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] =  temp;
                i++;
                j--;
            }
        }
        if ( j > low )
            quickSort(arrays, low, j );
        if ( i < high)
            quickSort(arrays, i, high);
    }
}
