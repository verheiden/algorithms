package com.example;

import java.util.Scanner;

import sun.rmi.runtime.Log;
/* solution to reverse the contents of an array  of numbers by Jung Verheiden */
public class ReverseArray
{
    public static void main(String args[])
    {
        try {

            Scanner reader = new Scanner(System.in);
            System.out.println("Type in total number of input integer");
            int N = reader.nextInt();
            if ((N < 0) || (N > 1000)) {
                System.out.println(" Total number out of boundry");
                System.exit(-1);
            }
            int[] numbers = new int[N];
            int i = 0;
            System.out.println("Type in " + N + " input numbers");
            while (i <= (N -1)){
                numbers[i++] = reader.nextInt();
            }

            reverseInts(numbers);


            for (int number : numbers) {
                System.out.println(" " + number);
            }
        }
        catch(Exception e)
        {
            System.out.println("There was an exception " + e );
        }
    }

    static private void reverseInts(int[] numbers)
    {
        int i = 0;
        int j = numbers.length -1;

        while ( i < j )
        {
            swap(numbers, i, j);
            i++;
            j--;
        }
    }
    static private void swap(int[] numbers, int first, int second)
    {
        int tmp = numbers[first];
        numbers[first]= numbers[second];
        numbers[second] = tmp;
    }
}
