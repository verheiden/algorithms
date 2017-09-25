package com.example;
/* solutions to move all the zeros in the integer array to the end of the array
 * by Jung Verheiden.
 */
public class moveZerosToEnd {
    public static void  main(String[] args) {

        int[] array = new int[]{0, 3, 0, 4, 5, 0, 6, 9, 5, 9, 8, 2, 3, 0, 4, 1, -12, -4, -3, -4, -5, -1};
        moveZerosToEnd obj = new  moveZerosToEnd();
        obj.moveZeros(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("end");
    }
    private void moveZeros(int[] array)
    {
        int i= 0;
        int last= array.length -1;

        while(i  <  last )
        {
            while(array[i] != 0 )
            {
                i++;
            }
            while(array[last] == 0 ) {
                last--;
            }
            if ( last > i ) {
                swap(array, i, last);
            }
            i++;
            last--;
        }
    }
    private void swap(int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
