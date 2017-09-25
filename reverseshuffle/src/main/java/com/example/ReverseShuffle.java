package com.example;

import java.util.LinkedList;
import java.util.Scanner;

public class ReverseShuffle {
    final static int NALPHA = 26;
    public static void  main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String s = reader.next();
        System.out.print(ReverseShuffle(s));
    }

    static String ReverseShuffle(String S)
    {
        char[]  S1 = S.toCharArray();
        int[] freq  = new int[NALPHA];
        int[] notSeen = new int[NALPHA];
        int[]  written = new int[NALPHA];
        LinkedList<Integer>[]  positions = (LinkedList<Integer>[]) new LinkedList<?>[NALPHA];
        int[] nextUsed = new int[NALPHA];
        int[] need = new int[S1.length];
        char[] result = new char[S1.length/2];

        Reverse(S1);
        for ( int i = 0; i < NALPHA; i++){
            positions[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < S1.length ; i++)
        {
            freq[S1[i] - 'a']++;
            positions[S1[i]-'a'].add(i);
        }

        for ( int i = 0; i < NALPHA; i++)
        {
            freq[i] /= 2;
        }

        for ( int i= S1.length -1 ; i >= 0 ; i--)
        {
            int hash = S1[i] - 'a';
            need[i] = freq[hash] - notSeen[hash];
            notSeen[hash] = Math.min(notSeen[hash] +1, freq[hash]);
        }
        int size = 0;
        int bottleNeck = 0;
        int lastP = 0;
        int startP = 0;
        while ( size < S1.length/2)
        {

              while ( written[S1[bottleNeck]-'a'] >= need[bottleNeck ] )
                  bottleNeck++;

              int nextChar = 0;
              while ( written[nextChar] == freq[nextChar]  ||
                        (positions[nextChar].get(nextUsed[nextChar]) > bottleNeck))
                nextChar++;

              startP = positions[nextChar].get(nextUsed[nextChar]);

              while ( lastP != startP )
              {
                  nextUsed[S1[lastP] -'a']++;
                  lastP++;
              }
              do
              {
                  result[size++] = (char)(nextChar + 'a');
                  written[nextChar]++;
                  nextUsed[nextChar]++;
              } while ( written[nextChar] < need[startP]);
              lastP = startP + 1;

        }
        return(new String(result));
    }
    static void Reverse(char[] S){
        int N = S.length  -1  ;
        for ( int i = 0; i <  S.length/2; i++)
        {
            char tmp = S[i];
            S[i] = S[N - i ];
            S[N-i] = tmp;
        }
    }

}
