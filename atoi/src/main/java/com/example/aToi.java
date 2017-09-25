package com.example;
/*
**by Jung Verheiden, convert a number  in digits  to an integer number
*/
public class aToi {
    public static void main(String[] args){
        System.out.print( new aToi().myAtoi(new String("56748234")));
    }
    public int myAtoi(String str) {
        if ( str == null || str.length() == 0 )
            return 0;
        int decimal = 0;
        long sum = 0;
        for (int i = 0; i < str.length(); i++ )
        {
            char c = str.charAt(i);
            if ( ! isDigit(c) )
                return 0;
            sum = sum*10 + c - '0';

            if ( sum > Integer.MAX_VALUE )
            {
                return(Integer.MAX_VALUE);
            }
        }
        return( (int) sum);
    }
    boolean isDigit(char c)
    {
        if ( c >= '0'  && c <= '9')
            return true;
        else
            return false;
    }
}
