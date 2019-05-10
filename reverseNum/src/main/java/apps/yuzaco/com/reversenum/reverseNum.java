package apps.yuzaco.com.reversenum;

public class reverseNum {
        public static main(String[] args)
        {
            reverseDigit obj = new ReverseDigit();
            System.out.println( obj.reverse(-1234567891));
        }
        public int reverse(int b) {
            int sign = 1;
            int a = b;
            if ( b < 0 )
            {
                sign = -1;
                a = sign*b;
            }

            int   newNum = reverseOf(a);
            if ( newNum == Integer.MIN_VALUE )
                return 0;

            newNum *= sign;
            return newNum;
        }
        int reverseOf(int a)
        {
            int newNum = 0;
            while( a > 0 )
            {
                int  digit = a%10;
                if ( newNum >  (Integer.MAX_VALUE/10) ||  ((newNum ==  Integer.MAX_VALUE/10) && (digit > Integer.MAX_VALUE%10)))
                    return Integer.MIN_VALUE;
                newNum +=  newNum*10 + digit;
                a /= 10;
            }
            return newNum;
        }
}
