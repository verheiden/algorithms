package com.example;
/*
**by Jung Verheiden, convert a number  in digits  to an integer number
*/
public class aToi {
    public static void main(String[] args){
        System.out.print( new aToi().myAtoi(new String("56748234")));
    }
    public int myAtoi(String str) {
        if ( str == null )
            return 0;
        int sum = 0;
        for(int i = 0; i < str.length(); i++)
        {
            char cc = str.charAt(i);
            if ( !isDigit(cc))
                return 0;
            sum = sum*10 + (cc - '0');
        }
        return sum;
    }
    boolean isDigit(char c)
    {
        if ( c >= '0'  && c <= '9')
            return true;
        else
            return false;
    }
}
