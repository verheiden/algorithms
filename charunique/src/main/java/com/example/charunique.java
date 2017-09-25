package com.example;

import java.util.HashSet;
import java.util.Scanner;
/* solutions to determins a string is consists of all unique characters  by Jung Verheiden */
public class charunique {
        static void main(String[] args)
        {
            Scanner reader = new Scanner(System.in);
            String input = reader.next();
            if ( uniqueChars(input.toCharArray()) == true )
            {
                System.out.println("The string " + input + "has all unique Characters.");
            }
            else
            {
                System.out.println("The string " +  input + "is not all unique characters.");
            }
        }

        static boolean uniqueChars(char[] input)
        {
            int size = input.length;
            for ( int i = 0; i < size; i ++)
            {
                for ( int j = i + 1; j < size;  j++)
                {
                    if ( input[i] == input[j] )
                        return false;
                }
            }
            return true;
        }
        static boolean uniqueChars1(String a)
        {
            char[] cArray = a.toCharArray();
            for ( char c: cArray )
            {
                if ( a.indexOf(c) != a.lastIndexOf(c))
                    return false;
            }
            return true;
        }
        static boolean uniqueChars2(String input){
            HashSet<Character> uniques = new HashSet<>();
            for( char c: input.toCharArray())
            {
                if ( uniques.add(c)  == false )
                    return false;
            }
            return true;
        }
}
