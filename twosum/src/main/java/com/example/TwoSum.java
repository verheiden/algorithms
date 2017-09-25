package com.example;

import java.util.HashMap;

import static com.example.TwoSum.twoSum;

public class TwoSum {

    public static void main(String args[])
    {
        int[] numbers = { +7, 456, 890, -2000, 300, 111, 993, -999, 666, -345, 3005, 4000, 1001 };

        int[] indexes;

        if ( (indexes = twoSum(numbers, 1000) ) != null ) {
            System.out.println("index : " + indexes[0] + " second index : " + indexes[1]);
        }  else
        {
            System.out.println("There is no two sum that result in  1000");
        }
    }

    public static int[] twoSum(int[] array, int sum )
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;  i < array.length; i++){
            int complement = sum  - array[i];
            if ( map.containsKey(complement))
            {
                return ( new int[]  {i, map.get(complement)} );
            }
            else
            {
                map.put(array[i], i);
            }
        }
        return null;
    }
}
