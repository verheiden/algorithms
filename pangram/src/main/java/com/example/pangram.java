package com.example;

import java.util.Scanner;
/* Solution to find if a string is panindrome by Jung Verheiden */
public class pangram {

    public static void main(String[] args){
        String s;
        Scanner reader = new Scanner(System.in);
        System.out.println("Type in Next word");
        while( reader.hasNext())
        {
            s = reader.next();
            if (s.equals("end"))
                return;
            if ( palindrome(s.toCharArray()))
                System.out.println( s + " is palindrome");
            else
                System.out.println(s + " is not a palindrome");
        System.out.println("Type in next word ");
        }
    }

    static private boolean palindrome(char[]  chars){
        int Size = chars.length - 1;
        int i = 0;
        while(i <=  Size/2 ){
            if ( chars[i] != chars[Size - i ])
                return false;
            i++;
        }
        return true;
    }
}
