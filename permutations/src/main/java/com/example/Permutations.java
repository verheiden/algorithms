package com.example;

import java.util.Scanner;
/* solution to come up with all the permutations of a given string by Jung Verheiden */
public class Permutations {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Type in the string to be permuted");

        String input = reader.nextLine();
        String input2 = new String(input);
        permRecursion("", input);

    }
    public static void perm1(String prefix, String rest){
     int N = rest.length();
        if ( N == 0 ) {
            System.out.println(prefix);
            return;
        }
        for(int i = 0; i < N; i++)
          perm1(prefix+rest.charAt(i),  rest.substring(0, i) + rest.substring(i+1, N);

    }
    public static void permRecursion(String prefix, String s)
    {
         int N = s.length() ;
         if ( N  == 0  ){
             System.out.println(prefix );
             return;
         }
         for( int i = 0; i < N; i++)
         {
             permRecursion(prefix+s.charAt(i), s.substring(0, i) + s.substring(i+1,  N ));
         }
    }

    public static void swap(char[] array, int i, int j)
    {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
