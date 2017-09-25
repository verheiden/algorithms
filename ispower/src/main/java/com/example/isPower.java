package com.example;
/* solutions to determine whether a number is some power of 2 by  by Jung Verheiden */
public class isPower {
    public static void main(String[] args){
        String a = new String("1");
        System.out.println(new isPower().power(a));
    }
    public int power(String a) {
        if ( a == null  || a.length() == 0 )
            return 0;
        if (a.length() == 1 && (( a.charAt(0) == '1') || (a.charAt(0) == '2' )))
            return 1;
        String dividend = a;
        while(dividend.length() > 0   )
        {
            int n = dividend.length() -1;
            int lastDigit = dividend.charAt(n) - '0';
            if (( dividend.length() == 1 ) && ( lastDigit == 2 ))
            {
                return 1;
            }
            if ( lastDigit%2 != 0 )
                return 0;

            dividend = divideBy(dividend);
        }
        return 0;
    }

    String divideBy(String a)
    {
        StringBuffer buf = new StringBuffer();
        boolean carry = false;
        for (int i = 0; i < a.length(); i++ )
        {
            int digit = a.charAt(i) - '0';
            if ( carry )
                digit += 10;

            if ( digit%2 == 1 )
                carry = true;
            else
                carry = false;
            char c = (char) ((digit/2) + '0' );
            buf.append(c);
        }
        if ( buf.charAt(0) == '0')
            buf.deleteCharAt(0);
        return buf.toString();
    }
}
