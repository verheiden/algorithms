package com.example;

import java.util.Scanner;

/**
 * Created by jung on 2/1/16.
 */
public class BiggerSave
{
        static final int NUM_ALPHABET = 27;

        public static void main(String args[]) {
            Scanner reader = new Scanner(System.in);
            int T = reader.nextInt();

            while (T-- > 0) {
                String s = reader.next();
                System.out.println(BiggerGreater(s));
            }
        }

        static String BiggerGreater(String is) {
            char[] newString = is.toCharArray();
            boolean charFound = false;
            int ic, iSum;
            int bigger, iiBigger, iLowest;
            int  lexSum1, lexSum2, finalSum;
            for (int i = 0; i < is.length() - 1; i++)
            {
                char c = newString[i];
                char cii = newString[i+1];
                char cj;
                iSum = ic = i;
                iiBigger = bigger = 0;

                finalSum = lexSum1 = ( newString[i] - 'a' + 1 )*NUM_ALPHABET + (newString[i+1]- 'a' + 1);
                iLowest = i;
                for (int j = i + 1; j < is.length(); j++) {
                    cj = newString[j];
                    if (charFound) {
                        if (newString[ic] > cj) {
                            ic = j;
                        }
                    }
                    else
                    {
                        if ( cj <= newString[iLowest] )
                        {
                            iLowest = j;
                        }
                        if ( cj > c )
                        {
                            bigger++;
                            if (bigger == 1) {
                                ic = j;
                            }
                            else
                            {
                                if (cj < newString[ic])
                                    ic = j;
                            }
                        }
                        if ( cj >= cii )
                        {
                            iiBigger++;
                            lexSum2 =  (newString[j]  - 'a' + 1)*NUM_ALPHABET + ( newString[i] - 'a' + 1 );
                            if ( lexSum2 > lexSum1 )
                            {
                                if (( iiBigger == 1 )  )
                                {
                                    finalSum = lexSum2;
                                    iSum = j;
                                }
                                else {
                                    if (finalSum > lexSum2) {
                                        finalSum = lexSum2;
                                        iSum = j;
                                    }
                                }
                            }
                        }

                    }
                }
                if ( !charFound )
                {

                    if ((iiBigger == 0 ) && (finalSum > lexSum1))
                    {
                        swap(newString, i, iSum);
                        charFound = true;

                    }
                    else if ((bigger >=1 ) && ( i != iLowest ))
                    {
                        if ( ic != i )
                        {
                            swap(newString, i, ic);
                            charFound = true;
                        }
                    }
                }
                else
                {
                    if ( i != ic )
                        swap(newString, i, ic);
                }
            }
            if ( charFound )
                return(new String(newString));
            else
                return(new String("no answer"));
        }

        static void swap(char[] array, int i, int j)
        {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

    }

