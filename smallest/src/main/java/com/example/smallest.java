package com.example;

public class smallest {
    public static void main(String args[])
    {
         int[] numbers = { -1, 456, 890, -2000, 300, 111, 2000, -999, 666, -345, 3000, 4000 };

         int sum = 0;
         int minSum = 0;
         smallest(numbers);
    }

    public static  void  smallest(int[] numbers)
    {
        long  sum, minSum;
        sum = 0;
        minSum = 0;
         int minStart = 0;
         int minEnd = 0;

        for(int i = 0; i < numbers.length; i++)
        {
           sum = numbers[i];
           for(int j = i+1; j < numbers.length; j++)
           {
               sum += numbers[j];
               if ( sum < minSum)
               {
                   minStart = i;
                   minEnd = j;
                   minSum = sum;
               }
           }
        }
        System.out.println("Smallest substring index starts at " + minStart );
        System.out.println("Index ends at " + minEnd);
        System.out.println("Sum is : " +  minSum );
    }
}
