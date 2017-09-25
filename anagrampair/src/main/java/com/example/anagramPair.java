package com.example;

import java.util.Scanner;

/* Solution by Jung Verheiden for hacker ranker anagram pair */
public class anagramPair {


        static final int ALPHABET =  256;
        public static void main(String args[]) {
            Scanner stdin = new Scanner(System.in);
            int T = stdin.nextInt();
            String s1 = new String("abcdefg");
            String s2 = new String("gfedcab");
            String s3 = new String("AppleBee");
            String s4 = new String("BeeApple");
            String s5 = new String("TheSprin");

           if ( isAnagramPair(s1,s2))
           {
               System.out.println(s1 + " : " + s2 + " is anagram");
           }
            if ( !isAnagramPair(s3, s5 ))
            {
                System.out.println(s3 + " : " + s5 + " is not anagram");
            }
        }

        public  static boolean isAnagramPair(String s1, String s2)
        {
            int flags[] = new int[256];
            int slen = s1.length();
            if (slen < 2 )
                return false;
            if ( slen != s2.length() )
                return false;
            for(int i = 0; i < slen; i++)
            {
                flags[s1.charAt(i)]++;
                flags[s2.charAt(i)]--;
            }
            for(int i = 0; i < slen; i++){
                if ( flags[s1.charAt(i)] != 0 )
                    return false;
            }
            return true;
        }

    }
