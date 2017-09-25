package com.example;
/* solutions for binary tree by Jung Verheiden */
public class heap {
    static int[] numbers = {  -1, 23456, -11, 23456, -111, 0, 456, 789, 1 ,4 ,8, -99 };
    static int Size;
    static public void main(String[] args){

        heapSort(numbers);
        System.out.println("\nHeap sorted array\n");
        for(int i : numbers ){
            System.out.print(" " + i);
        }
    }
    static private void heapify(int[] arrays)
    {
       Size = arrays.length -1;

        for ( int i = Size/2; i>= 0; i--)
        {
            maxHeap(arrays, i);
        }
    }
    static private void maxHeap(int[] arrays, int index)
    {
        int left = index*2;
        int right = left + 1;
        int largest = index;
        if (( left < Size ) && ( arrays[left] > arrays[largest]))
        {
            largest = left;
        }
        if ((right < Size) && ( arrays[right] > arrays[largest]))
        {
            largest = right;
        }
        if ( largest != index )
        {
            int tmp = arrays[index];
            arrays[index] = arrays[largest];
            arrays[largest] = tmp;
            maxHeap(arrays, largest);
        }

    }
    static private void heapSort(int[] arrays){
       heapify(arrays);
        while( Size > 0 )
        {
            swap(arrays,0, Size);
            Size--;
            maxHeap(arrays, 0);
        }
    }

    static void swap(int[] arrays, int i, int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;

    }
}
