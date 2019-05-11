package com.example;
/* solutions for binary tree by Jung Verheiden */
public class heap {
    static int[] numbers = {  -1, 23456, -11, 23456, -111, 0, 456, 789, 1 ,4 ,8, -99 };
    static int[] numbers1 = {  -1, 23456, -11, 23456, -111, 0, 456, 789, 1 ,4 ,8, -99 };
    static int Size;
    static public void main(String[] args){

        heapSort(numbers);
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
    static void heapSort(int[] data){
         Total = data.length -1;
         heapify(data);
         while(Total > 0 ){
            swap(data, 0, Total) ;
            Total--;
            maxHeap(data, 0);
         }
    }
    static void maxHeap(int[] data, int parent)
    {
        int N = data.length;
        int left = 2*parent;
        int right = left + 1;
        int largest = parent;
        if ( (left < N) && data[left] > data[largest])
        {
            largest = left;
        }
        if ( right < N && data[right] > data[largest]){
            largest = right;
        }

        if ( largest != parent )
        {
            swap(data, largest, parent );
            maxHeap(data, largest)  ;
        }
    }
    static void heapify(int[] data){
        int N = data.length -1;
        for(int i = N/2; i >= 0; i--)
        {
            maxHeap(data, i);
        }
    }

    static private void quickSort(int[] arrays, int low, int high)
    {
        if ( low >= high )
            return;
        int pivot = arrays[(low + high)/2];
        int i = low;
        int j = high;
        while( i < j  )
        {
            while( arrays[i] < pivot )
            {
                i++;
            }
            while( arrays[j] > pivot )
            {
                j--;
            }
            if ( i <= j ) {
                swap(arrays, i, j);
                i++;
                j--;
            }
        }
        if ( low < j )
            quickSort(arrays, low, j);
        if ( i < high )
            quickSort(arrays,i, high );
    }
}
