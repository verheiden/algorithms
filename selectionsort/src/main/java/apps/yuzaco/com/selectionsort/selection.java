package apps.yuzaco.com.selectionsort;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class selection
{
    public static void main(String a[]) {
        int[] numbers = {102, 3, 7, 235, 202, 709, -1, 8, 21};
        selectionSort(numbers);
        for (int i : numbers) {
            System.out.print(i);
            System.out.print(", ");
        }
    }
    private static void  selectionSort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int smallest = i;
            for(int j = i+1; j < array.length; j++)
            {
                if ( array[j] < array[smallest] )
                {
                    smallest = j;
                }
            }
            if ( i != smallest )
            {
                int temp = array[i];
                array[i]= array[smallest];
                array[smallest] = temp;
            }
        }
    }
}
