package com.example;

/* solutions to find a smallest of bigger number  by Jung Verheiden */
import java.util.Scanner;
import java.util.Arrays;
public class GreaterBigger1
{

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();

        while (T-- > 0) {
            String s = reader.next();
            System.out.println(BiggerGreater(s));
        }
    }

    static String BiggerGreater (String s)
    {
        int len, i;
        char[] mystring = s.toCharArray();


        len = mystring.length;
        if (len < 2)
            return (new String("no answer")); /* No answer */
        i = len  - 2;


        while (i >=0 ) {
            if (mystring[i] < mystring[i+1]) {
                int j, mindex = i+1;
                char tmp;
             /* Now we know at least one character after mystring[i] is
                greater than mystring[i], find the smallest of these.
              */
                for (j = i + 1; j < len; j++) {
                    if ((mystring[j] > mystring[i]) &&
                        (mystring[j] < mystring[mindex])) {
                        mindex = j;
                    }
                }
             /* OK, now we know that mystring[mindex] is the smallest char
                that is greater, swap these.
              */
                tmp = mystring[mindex];
                mystring[mindex] = mystring[i];
                mystring[i] = tmp;

             /* Finally, sort everything from mystring[i + 1] to
                mystring[len]
              */
               quicksort( mystring, i+1, len - 1);

                return ( new String(mystring));
            }
            i--;
        }
        return (new String("no answer")); /* No answer */
    }
    static void swap(char[] array, int i, int j)
    {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void  quicksort(char[] numbers, int low, int high)
    {
        if ( low < high )
        {
            int index = partition(numbers, low, high);
            quicksort(numbers, low, index - 1);
            quicksort(numbers, index +1, high);
        }
    }
    static int partition(char[] input, int low, int high)
    {
        int pivot = input[high];
        int i = low;
        for(int j = low; j <  high   ; j++)
        {
            if ( input[j] <=  pivot ){
                swap(input,i, j );
                i++;
            }
        }
        swap(input, i, high);
        return  i;
    }
}
