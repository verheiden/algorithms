package apps.yuzaco.com.interview;

import java.util.Scanner;

/**
 * Created by jung on 10/22/15.
 */
public class reverseString {
    static public  char[]  reverseString(char[] str)
    {
        if ( str.length == 1 )
            return str;
        else
        {
            int i = 0;
            int j = str.length -1;
            while ( i < j )
            {
                char c = str[i];
                str[i++] = str[j];
                str[j--] = c;
            }
        }
        return str;
    }
    public int binarySearch(int[] arr, int key)
    {
        int start = 0;
        int end = arr.length - 1;
        while ( start <= end )
        {
            int mid = (start + end )/2;
            if ( key == arr[mid])
                return mid;
            if ( key < arr[mid])
                end = mid -1;
            else
                start = mid + 1;
        }
        return -1;
    }
    public static void main(String a[]) {

        Scanner reader = new Scanner(System.in);
        char[] inputs;
        String input;

        System.out.println("Type in a line of string to reverse");
        input = reader.nextLine();
        inputs = reverseString(input.toCharArray());
        System.out.println("Reversed String : " + inputs );
    }
}
