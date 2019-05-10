/**
 * Created by jung on 10/22/15.
 */
import java.util.Scanner;

public class HeapSort {

    private static int N;

    public static void buildheap(int arr[])
    {
      heapify(arr);
      for (int i = N; i>0; i--)
        {
            swap(arr, 0, i);
            N -= 1;
            maxHeap(arr, 0);
        }
    }

    /* Function to build a heap */
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxHeap(arr, i);
    }
    /* method to swap the largest element to the top */
    public static void maxHeap(int arr[], int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;

        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;
        if (max != i) {
            swap(arr, i, max);
            maxHeap(arr, max);
        }
    }
    public static void swap(int a[], int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

}
