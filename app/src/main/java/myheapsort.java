/**
 * Created by jung on 1/24/16.
 */
public class myheapsort {
    static int N;
    public static void main(String args[])
    {
        int[] numbers = {-2, 345, 123, 456, 7, -11, 12, 201, 205, 111, 2001, 45};

        myheapsort(numbers);
        for(int number: numbers) {
            System.out.print(number);
            System.out.print("\n");
        }
    }
    /*
     * heapsort - sorts the given integer array in an ascending order
     * by iteratively selecting the max number into the root element and
     * moving into the Nth position of the array.
     */
     private static void myheapsort(int[] list )
     {
         heapify(list);

         for (int i = N; i >= 0; i++) {
             swap(list, 0, i);
             N--;
             maxheap(list, 0);

         }
     }
    private static void heapify(int[] list)
    {
        N = list.length - 1;
        for ( int i = N/2; i >=0; i++)
        {
            maxheap(list, i);
        }
    }

    private static void maxheap(int[] list, int i)
    {
        int left = 2*i;
        int right = 2*i + 1;
        int max = i;
        if ( list[left]  > list[max] )
            max = left;
        if ( list[right] > list[max])
            max = right;
        if ( max != i ) {
            swap(list, i, max);
            maxheap(list, max);
        }
    }
    private static  void swap(int[] list, int i, int j)
    {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;

    }

}
