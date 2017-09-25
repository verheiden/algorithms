package com.example;

/*
** By Jung Verheiden, implement an algorithm to randomly select a number of out
* of given array of numbers.
*/
import java.util.HashMap;
import java.util.Random;

public class newRandom {
    static public void main(String[] args){
        int[] numbers = new int[] { 11, 12, 13, 14, 15, 16 , 17, 18, 19, 20, 21 };
        newRandom obj = new newRandom();
        System.out.println("First Special Random: " + obj.getRandom(100, numbers));
        System.out.println("Second Special Random: " + obj.getRandom(3000, numbers));
        System.out.println("Third Special Random: " + obj.getRandom(5000, numbers));
    }


    int getRandom(int bounds,int[] numbers){
        Random rand = new Random();
        HashMap<Integer, Integer> tTable = new HashMap<>();
        for ( int i = 0;  i < numbers.length; i++)
        {
            tTable.put(numbers[i], i);
        }

        while(true) {
            int number = rand.nextInt(bounds);
            if (!tTable.containsKey(number))
                return number;
        }
    }
}
