package apps.yuzaco.com.interview;

/**
 * Created by jung on 10/22/15.
 */
public class QuickSort {
    private int length;
    private int array[];
    public void sort(int[] arr)
    {
        if ( arr == null || arr.length == 0)
            return;
        array = arr;
        length = arr.length;
        quickSort(0, length -1);
    }
    private void quickSort(int low, int high)
    {
        int i = low;
        int j = high;
        int pivot = array[low + ( high - low )/2 ];

        while(i <= j )
        {
            while(array[i] < pivot)
              i++;
            while(array[j]> pivot)
                j--;
            if ( i <= j ){
                swap(i, j);
                i++;
                j--;
            }
        }
        if ( low < j)
            quickSort(low, j);
        if ( i < high )
            quickSort(i, high);
    }
    private void swap( int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
