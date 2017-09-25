package com.example;
/* solutions to find maximum of longest  by Jung Verheiden */
public class MaxLongest {

      class Node {
          public int sum;
          public int first;
          public int size;

          Node(int sum, int first, int size)
          {
              this.sum = sum;
              this.first = first;
              this.size = 1;
          }
      }
       int numbers[] = {9, -10, 33, 56, -1234, -17, 28, 6, -3, 234, -256, 111,  34, -77, -234,  789, -111, 233, -347, 213, -399, 123};
       public static void main(String[]   args)
       {
           int[] numbers = new int[9];
           MaxLongest  array = new MaxLongest();

           Node longest = array.maxLongest();
           System.out.println(" Max Sum of Longest : " + longest.sum + " start Index : " + longest.first + " ends Index :"
               +  (longest.first + longest.size -1) );
       }
       public MaxLongest() {}
       private Node maxLongest()
       {
            Node maxSoFar = new Node(numbers[0], 0, 1);
            Node maxEndHere = new Node(numbers[0], 0, 1);

           for (int i = 1; i < numbers.length; i++)
           {
                int number = numbers[i];
                maxEndHere.sum += number;
                maxEndHere.size++;
                if (  number > maxEndHere.sum  ) {
                    maxEndHere.sum = number;
                    maxEndHere.first = i;
                    maxEndHere.size = 1;
                }
               if ( maxEndHere.sum > maxSoFar.sum )
               {
                   maxSoFar.first  = maxEndHere.first;
                   maxSoFar.sum = maxEndHere.sum;
                   maxSoFar.size = maxEndHere.size;
               }
               else if ( (maxEndHere.sum == maxSoFar.sum) && ( maxEndHere.size > maxSoFar.size))
               {
                   maxSoFar.first  = maxEndHere.first;
                   maxSoFar.sum = maxEndHere.sum;
                   maxSoFar.size = maxEndHere.size;
               }
           }
           return maxSoFar;
       }
}
