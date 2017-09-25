package com.example;

public class version {
    public static void main(String[] args) {
        String a = new String("1.003.5");
        String b = new String("1.3.6.1");
        version obj = new version();
        int i =  obj.compareVersion(a,b);
    }
    class  pair
    {
        public double value;
        public int eIndex;
        public pair(double val, int nextI)
        {
            value = val;
            eIndex = nextI;
        }
    }

    public int compareVersion(String a, String b)
    {
        int aSize = a.length();
        int bSize = b.length();

        int i = 0;
        int j = 0;
        while(( i  < aSize) || ( j < bSize))
        {
            pair tA = getVersion(a, i);
            pair tB = getVersion(b, j);

            if ( tA.value > tB.value  )
                return 1;
            else if ( tB.value > tA.value)
            {
                return  -1;
            }

            i = tA.eIndex;
            j  = tB.eIndex ;
        }
        return 0;
    }

    pair getVersion(String s, int start)
    {
        double  num  = 0;
        int i = start;
        double decimal = 1;
        if ( start >=s.length() )
            return new pair(0, start);
        while( (i < s.length()) && ( s.charAt(i) != '.'))
        {
            int digit = s.charAt(i) - '0';
            num *= decimal;
            num += digit;
            decimal *= 10;
            i++;
        }
        return ( new pair(num, i + 1 ));
    }
}
