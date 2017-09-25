package com.example;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueChars {
    static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        if ( uniqueChars(input) == true )
        {
            System.out.println("The string " + input + "has all unique Characters.");
        }
        else
        {
            System.out.println("The string " +  input + "is not all unique characters.");
        }
    }
    static boolean uniqueChars(String input)
    {
        char[] chars = input.toCharArray();
        for ( char c: chars){
            if ( input.indexOf(c) == input.lastIndexOf(c))
                return false;
        }
        return true;
    }
}
