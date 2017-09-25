package com.example;

import java.util.ArrayList;
import java.util.Collections;
/* solution to determine a numbe legitimate IP addesses out of a given string of digits
 * by Jung Verheiden.
 */
public class IpAddress {
    public static void main(String[] args){
        IpAddress obj = new IpAddress();
        //ArrayList<String> addrs = obj.restoreIpAddresses("0000");
        ArrayList<Integer> mem = new ArrayList<Integer>();
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(0);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(1);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(2);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        mem.add(3);
        //System.out.println(obj.convert(new String("PAYPALISHIRING"), 3 ));
        System.out.println(obj.removeDuplicates(mem));
    }
    public int removeDuplicates(ArrayList<Integer> a) {
        int count = 0;
        if (  a.size() == 1 )
            return 1;
        int previous = a.get(0);
        int i = 1;
        int k = 1;
        while( i <= ( a.size() -1 ))
        {
            if ( previous == a.get(i))
            {
                while( i <= a.size()-1 && ( previous == a.get(i)))
                {
                    count++;
                    if ( count == 1 )
                    {
                        a.set(k, a.get(i));
                        k++;
                    }
                    previous = a.get(i);
                    i++;
                }
                count = 0;
            }
            else if ( previous != a.get(i) )
            {
                previous = a.get(i);
                a.set(k, a.get(i));
                i++;
                k++;
                count = 0;
            }
        }
        int deleted = a.size() - k;
        for ( i= 0; i < deleted ; i++)
        {
            a.remove( a.size() -1 );
        }
        return k;
    }
    String a;
    ArrayList<String> ans;
    int n;
    public ArrayList<String> restoreIpAddresses(String a) {
        this.a = a;
        ans = new ArrayList<>();
        int num =0;;
        int i = 0;
        n = a.length();
        if ( a.length() >= 4 )
        {
            StringBuffer ips = new StringBuffer();
            recv( 0, ips, 3 );
        }
        return ans;
    }
    public int removeElement(ArrayList<Integer> a, int b) {
        int num = 0;
        for ( int i = 0; i < a.size(); i++)
        {
            if ( a.get(i) == b )
            {
                num++;
            }
            else
            {
                a.set(i-num, a.get(i));
            }
        }
        for (int i = 0; i < num; i++)
            a.remove(a.size() - 1);
        return num;
    }
    void recv( int i, StringBuffer ips, int leftDot)
    {

        if (( leftDot == -1  ) && ( i >= n ))
        {
            ans.add(ips.toString());
            return;
        }
        if (( leftDot == 0 ) && (n-i)>3)
            return;
        if ( i >= n )
            return;
        if ( a.charAt(i) == '0' )
        {
            ips.append('0');
            if  ( leftDot >= 1 )
                ips.append( '.');
            else if (( leftDot == 0 ) && ( (i< (n-1)) && ( a.charAt(i+1) == '0' )))
                return;
            StringBuffer nIp = new StringBuffer(ips.subSequence(0, ips.length()));
            recv( i+1, nIp,  leftDot  -1);
        }
        else if ( a.charAt(i) >= '1' && ( a.charAt(i) <= '9'))
        {
            StringBuffer nIp = new StringBuffer(ips.subSequence(0, ips.length()));
            nIp.append(a.charAt(i));
            if ( leftDot >= 1 )
                nIp.append('.');
            recv(i+1, nIp, leftDot -1 );
            for ( int j = i+1;  (j <= (n-1) && j <= (i+2)); j++)
            {
                if ( a.charAt(j) >= '0' && (a.charAt(j) <= '9'))
                {
                    if ( digitToNum( a.substring(i,j+1))  > 255 )
                        return;
                    nIp = new StringBuffer(ips.subSequence(0, ips.length()));
                    nIp.append( a.substring(i,j+1));
                    if  ( leftDot >= 1 )
                        nIp.append( '.');
                    recv(j+1, nIp,leftDot - 1);
                }
            }
        }
    }

    int digitToNum(String s)
    {
        int sum = 0;
        for ( int i = 0; i< s.length(); i++ ){
            sum *= 10;
            sum += s.charAt(i) - '0';
        }
        return sum;
    }
    /*
    public ArrayList<String> restoreIpAddresses(String a)
    {
        ArrayList<String> results = new ArrayList<String>();

        int n = a.length();
        digitsToIpAddr(a, results, 0, 3, "");
        Collections.sort(results);
        return(results);
    }
*/
    void digitsToIpAddr(String s, ArrayList<String> addrs, int startIndex, int ipSubNum, String partialIp )
    {
        int len = s.length();
        if ( ipSubNum == 0 )
        {

            if ( ((len - startIndex ) > 3 ) || ((len - startIndex) < 1  ))
            {
                return;
            }
            String sIp   = s.substring(startIndex, len);
            if ( sIp.charAt(0) == '0' && ( sIp.length() > 1 ))
                return;
            int num = Integer.parseInt(sIp) ;

            if ( num > 255 )
                return;
            addrs.add(partialIp  + sIp) ;

            return;
        }

        for ( int i = startIndex + 1; i <= ( Math.min( startIndex + 3,len)); i++ )
        {
            String sSub = s.substring(startIndex, i);

            if (( sSub.charAt(0) == '0') && ( sSub.length() > 1 ))
            {
                return;
            }
            int num = Integer.parseInt(sSub);
            if ( num > 255 )
            {
                continue;
            }
            digitsToIpAddr(s,addrs, i , ipSubNum - 1, partialIp + sSub + "." );
        }
    }
    public String convert(String a, int b)
    {
        int len = a.length();
        if ( len <= 1 )
            return a;
        if ( b <= 1 )
            return a;
        ArrayList<StringBuffer> zigZag = new ArrayList<StringBuffer>();
        int n =b;
        while(n-- > 0 )
        {
            zigZag.add( new StringBuffer());
        }
        boolean downward = true;
        int row = 0;
        for ( int i = 0; i < len; i++)
        {
            char c = a.charAt(i);
            StringBuffer s = zigZag.get(row);
            s.append(c);
            if ( downward)
            {
                if ( row == (b -1)) {
                    downward = !downward;
                    row--;
                }
                else
                    row++;
            }
            else /* Upward */
            {
                if ( row == 0 ) {
                    downward = !downward;
                    row = 1;
                }
                else
                    row--;
            }
        }
        StringBuffer answer = new StringBuffer();
        for ( int i = 0; i < b; i++){
            StringBuffer s = zigZag.get(i);
            for(int j = 0; j < s.length(); j++)
            {
                answer.append(s.charAt(j));
            }
        }
        return answer.toString();
    }
}
