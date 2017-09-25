package com.example;

/*
** By Jung Verheiden, count numbers of ways to interprete an expression to be true
*/
import java.util.ArrayList;
import java.util.Arrays;

public class CountTrue {
    int[][] t;
    int[][] f;
    int N;
    StringBuffer oper;
    StringBuffer opnd;
    static public void main(String[] args){
        String a = new String("T^T^T^F|F&F^F|T^F^T");
        CountTrue obj = new CountTrue();
        System.out.println("Count ways to true expression  : " + obj.cnttrue(a));
    }
    public int countTrue(String s)
    {
        if ( s== null || s.length() == 0 )
            return 0;

        N = s.length();

        oper = new StringBuffer();
        opnd = new StringBuffer();

        for ( int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'T' || c == 'F') {
                opnd.append(c);
            } else
                oper.append(c);
        }
        int size = opnd.length();
        t = new int[size][size];
        f = new int[size][size];
        for ( int i = 0; i < size; i++){
            Arrays.fill(t[i], -1 );
            Arrays.fill(f[i], -1);
            if ( opnd.charAt(i) == 'T')
            {
                t[i][i] = 1;
                f[i][i] = 0;
            }
            else
            {
                f[i][i] = 1;
                t[i][i] = 0;
            }
        }
        int ans = tr1(0, size-1);
         return(ans%1003);
    }
    int tr1(int i, int j)
    {
        if ( i > j )
            return 0;
        if ( t[i][j] != -1 )
            return t[i][j];
        int ans = 0;
        for ( int k = i; k < j; k++)
        {
            switch(oper.charAt(k))
            {
                case '&':
                    ans += tr1(i,k) * tr1(k+1, j);
                    break;
                case '|' :
                    ans += tr1(i,k) * tr1(k+1, j) + tr1(i,k)*fa1(k+1, j) + fa1(i,k)*tr1(k+1, j );
                    break;
                case '^' :
                    ans += tr1(i,k)*fa1(k+1, j) + fa1(i,k)*tr1(k+1, j);
            }
        }
        if ( ans >= 1003 )
            ans %= 1003;
        return ans;
    }
    int fa1( int i, int j){
        int ans = 0;
        for ( int k = i; k < j; j++){
            switch(oper.charAt(k))
            {
                case '&' :
                    ans += fa1(i,k)*fa1(k+1,j) + fa1(i,k)*tr1(k+1,j) + tr1(i, k)*fa(k+1, j);
                    break;
                case '|' :
                    ans += fa1(i,k)*fa1(k+1,j);
                    break;
                case '^' :
                    ans += tr1(i,k)*tr1(k+1, j) + fa1(i,k)*fa1(k+1,j);
                    break;
            }
        }
        if ( ans >= 1003 )
            ans %= 1003;
        return ans;
    }
    public int cnttrue(String a) {
        if ( a == null || a.length() == 0 )
            return -1;

        N = a.length();

        oper = new StringBuffer();
        opnd = new StringBuffer();

        for ( int i = 0; i < N; i++)
        {
            char c = a.charAt(i);
            if ( c == 'T'  || c == 'F' )
            {
                opnd.append(c);
            }
            else
                oper.append(c);
        }
        N = opnd.length();
        t = new int[N][N];
        f = new int[N][N];
        for ( int i = 0; i < N; i++)
        {
            Arrays.fill(t[i], -1);
            Arrays.fill(f[i], -1);
            if ( opnd.charAt(i) == 'T' ) {
                t[i][i] = 1;
                f[i][i] = 0;
            }
            else {
                f[i][i] = 1;
                t[i][i] = 0;
            }
        }
        int ans = tr(0, N-1);
        return(ans );
    }

    int tr(int i, int j)
    {
         if ( i > j ) return 0;

         if ( t[i][j] != -1 )
             return t[i][j];
            int ans  =0;
            for ( int k = i; k < j; k++ )
            {
                switch(oper.charAt(k))
                {
                    case '&':
                        ans  += tr(i,k) * tr(k+1, j);
                        break;
                    case '|' :
                        ans += tr(i,k) * tr(k+1, j) + tr(i,k)*fa(k+1, j) + fa(i,k)*tr(k+1, j);
                        break;
                    case '^':
                        ans += tr(i,k) * fa(k+1, j) + fa(i,k)*tr(k+1, j);
                        break;
                }
            }

            if ( ans >= 1003 )
                ans %= 1003;
            return(t[i][j] = ans);
    }
    int fa(int i, int j)
    {
        if ( i > j ) return 0;
        if ( f[i][j] != -1 )
            return f[i][j];
        int ans = 0;
        for ( int k = i; k < j; k++ )
        {
            switch(oper.charAt(k))
            {
                case '&':
                    ans  += tr(i,k)*fa(k+1, j) + fa(i,k)*tr(k+1, j) + fa(i,k)*fa(k+1, j) ;
                    break;
                case '|' :
                    ans += fa(i,k) * fa(k+1, j);
                    break;
                case '^':
                    ans += fa(i,k) * fa(k+1, j)  + tr(i,k)*tr(k+1, j);
                    break;
            }
            if (ans>= 1003)
                ans %= 1003;
        }
        return( f[i][j] = ans);
    }
}
