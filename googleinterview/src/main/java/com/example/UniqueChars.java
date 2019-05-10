package com.example;

import java.util.Scanner;

class uniquechars {
    static int[] bits;

    static void main(String[] args)
    {
        bits = new int[8];
        for (int i = 0; i < 32; i++)
            bits[i] = 0;
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        if (uniqueChars(input.toCharArray()) == true) {
            System.out.println("The string " + input + "has all unique Characters.");
        } else {
            System.out.println("The string " + input + "is not all unique characters.");
        }
    }

    static boolean uniqueChars(char[] input)
    {
        int size = input.length;


        for (int i = 0; i < size; i++) {
            if (checked(input[i])) {
                return false;
            }
        }
        return true;
    }

    static boolean checked(char c)
    {
        int index = c / 32;
        int bitIndex = c % 32;

        if ((bits[index] & (1 << bitIndex)) != 0)
            return true;
        else {
            bits[index] |= 1 << bitIndex;
            return false;
        }
    }
}
