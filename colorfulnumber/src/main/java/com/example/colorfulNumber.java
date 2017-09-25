package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/* solutions to determins if a number is colorful number by Jung Verheiden */

public class colorfulNumber {
    int[][][] remember;
    ArrayList<Integer> a;


    public static void main(String[] args){
       String s = new String("5070602400912917605986812821504");
        //String s = new String("16");
        colorfulNumber obj = new colorfulNumber();
        ArrayList<Integer> a = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        a.add(1967513926);
        a.add(1540383426);
        a.add(-1303455736);
        a.add(-521595368);
        list.add(5);
        list.add(7);
        list.add(7);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(10);
        list.add(10);
        int n = list.size() -1 ;
        obj.searchRange(list, 3);


    }
    // DO NOT MODIFY THE LIST
    ArrayList<Integer> answer = new ArrayList<Integer>();
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int n = a.size();

        findIndex(a, b,  0, n  -1 );
        if ( answer.size() == 0 )
        {
            answer.add(-1);
            answer.add(-1);
        }
        return answer;
    }
    void findIndex(List<Integer> a, int target, int start, int end)
    {
        if ( start > end )
            return ;
        if ( a.get(start) > target )
            return ;
        if ( a.get(end)  < target )
            return;

        int middle = (start + end )/2;
        if (  a.get(start) == target )
        {
            answer.add(start);
            answer.add(findEnd(a, target, start, a.size()  -1 ));
            return;
        }
        int aMiddle = a.get(middle);
        if ( target < aMiddle )
        {
            end = middle;
        }
        else
        {
            start = middle;
        }
        findIndex(a, target, start, end);
    }
    int findEnd( List<Integer> a, int target, int start, int end)
    {
        int middle ;
        if ( start >=  end )
        {
            return(start);
        }

        middle = (start + end )/2;
        if ( a.get(middle) > target )
        {
            return( findEnd( a, target, start, middle -1 ));
        }
        else
        {
            return( findEnd( a, target, middle , end ));
        }
    }
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int sIndex = -1;
        int eIndex = 0;
        int maxSIndex = -1;
        int maxEIndex = -1;
        long curSum = 0;
        long maxSum = 0;
        int n = a.size();

        for ( int i = 0; i < n; i++ )
        {
            if ( a.get(i) >= 0  )
            {
                if ( sIndex == -1 )
                {
                    sIndex = i;
                }
                curSum += a.get(i);
                eIndex = i;
                if ( i == ( n -1 ))
                {
                    if ( maxSum < curSum )
                    {
                        maxSum = curSum;
                        maxSIndex = sIndex;
                        maxEIndex = eIndex;
                    }
                    else if ( maxSum == curSum )
                    {
                        if ( (eIndex - sIndex ) > (maxEIndex - maxSIndex))
                        {
                            maxSum = curSum;
                            maxSIndex = sIndex;
                            maxEIndex = eIndex;
                        }
                    }
                }
            }
            else if ( sIndex !=  -1 )
            {
                if ( maxSum < curSum )
                {
                    maxSum = curSum;
                    maxSIndex = sIndex;
                    maxEIndex = eIndex;
                }
                else if ( maxSum == curSum )
                {
                    if ( (eIndex - sIndex ) > ( maxEIndex - maxSIndex ))
                    {
                        maxSum = curSum;
                        maxSIndex = sIndex;
                        maxEIndex = eIndex;
                    }
                }
                sIndex = -1;
                curSum = 0;
            }
        }
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if ( maxSIndex != -1 )
        {


            for ( int i = maxSIndex; i <= maxEIndex; i++)
            {
                answer.add(a.get(i));
            }
        }
        return answer;
    }
    public int maxcoin(ArrayList<Integer> A)
    {
        if ( A == null )
            return 0;
        a = A;
        int n = a.size();
        remember = new int[2][n][n];
        for ( int k = 0; k <2; k++)
        {
            for ( int i =0; i<n; i++)
            {
                for( int j = 0; j< n; j++){
                    remember[k][i][j]= -1;
                }
            }
        }
        return( rec(0, n-1, 0));
    }

    int rec(int start, int end, int user)
    {
        int sum = 0;
        try {
            if (start == end) {
                remember[user][start][end] = 0;
                return 0;
            }
            if (remember[user][start][end] != -1)
                return remember[user][start][end];

            if (user == 0)
                sum = Math.max(a.get(start) + rec(start + 1, end, 1), a.get(end) + rec(start, end - 1, 1));
            else
                sum = Math.min(rec(start + 1, end, 0), rec(start, end - 1, 0));

        }
        catch ( Exception e)
        {
            System.out.println("Exception " + e );
        }
        return remember[user][start][end] = sum;
    }
  /*  public int maxcoin(ArrayList<Integer> a) {
        int aMaxSum = 0;
        int bMaxSum = 0;
        int index = 0;
        int low = 0;
        int high =a.size() -1 ;
        boolean aPlayer = true;
        while(low <= high )
        {
            if (a.get(low) > a.get(high))
            {
                if ( aPlayer)
                    aMaxSum += a.get(low);
                else
                    bMaxSum += a.get(low);
                low++;
            }
            else
            {
                if ( aPlayer )
                    aMaxSum += a.get(high);
                else
                    bMaxSum += a.get(high);
                high--;
            }
            aPlayer =  !aPlayer;
        }
        return( Math.max(aMaxSum, bMaxSum));
    }
    */
        public int colorful(int a) {
            if ( a <= 0 )
                return 0;

            HashSet<Integer> allProducts = new HashSet<Integer>();
            StringBuffer sNum = dfs(a);
            int nStart = 0;
            int nEnd;
            int nSize = 1;
            int nLen = sNum.length();
            char[]  cNum = new char[nLen+1];
            while ( nSize <= nLen )
            {
                nStart = 0;
                nEnd = nStart + nSize;
                while(nEnd <= nLen)
                {
                    sNum.getChars(nStart,nEnd, cNum, 0 );
                    cNum[nEnd] = '\0';
                    int number = products(cNum);
                    if ( allProducts.add(number) == false)
                    {
                        return 0;
                    }
                    nStart++;
                    nEnd = nStart + nSize;
                }
                nSize++;
            }
            return 1;
        }

        public int power(String a) {
            double number = 0;

            number = convert(a);
            double p2  =  (Math.log(number)/Math.log(2));

            if ( Math.pow(2, p2 ) == number )
                return 1;
            else
                return 0;
        }

        double convert(String a)
        {
            int n = a.length() - 1;
            double num = 0;
            double power = 1;
            for ( int  i = n ; i>= 0 ; i--)
            {
                double num1 = (double) (( a.charAt(i) - '0' ) * power);
                num += num1;
                power *= 10;
            }

            return num;
        }

        int products(char[] sNum)
        {
            int index = 0;
            int product = 1;
            char c;
            while( ( c = sNum[index++] )!= '\0' )
            {
                product *=  c  - '0';
            }
            return product;
        }

        StringBuffer dfs(int num){
            StringBuffer buf = new StringBuffer();


            while(num > 0 )
            {
                int digit = num%10;
                char d = (char) ( digit + '0');
                buf.append( d );
                num  /= 10;
            }
            buf.reverse();
            return buf;
        }

        public int powerNumber(String a) {

        if (( a == null ) || a.length() == 0 )
            return 0;
        String new1 = a;
        while( new1.length() != 1 )
        {
            if ( isEven(new1)  )
            {
                new1 = divideBy2(new1);
            }
            else
            {
                return 0;
            }
        }

        int c = new1.charAt(0);
        if ( ( c == '2' )|| (c == '4') || ( c == '8'))
            return 1;
        else
            return 0;
    }

    String divideBy2(String in)
    {
        int index = 0;
        int len = in.length();
        StringBuffer new1 = new StringBuffer();
        char dividend;
        int carryOver = 0;
        while( index < len)
        {
            char  c =  (char)  ((in.charAt(index)) - '0');
            if ( carryOver  == 1 )
            {
                c += 10;
            }
            carryOver = c%2;
            dividend = (char) ( c/2 + '0') ;
            index++;
            if (( new1.length() == 0 ) && ( dividend == '0' ))
                continue;
            new1.append((char) (dividend));
        }
        return new1.toString();
    }
    boolean isEven(String s)
    {
        int end = s.length()  - 1;
        int c  = ( s.charAt(end)) - '0';
        if ( ( c & 1 ) == 1 )
            return false;
        else
            return true;
    }
}
