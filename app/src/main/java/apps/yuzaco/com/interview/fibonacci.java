package apps.yuzaco.com.interview;

/**
 * Created by jung on 10/22/15.
 */
public class fibonacci {

    public static int fibonacci(int n)
    {
       if ( n == 0)
           return 0;
       if ( n == 1 )
           return 1;
       int febn0 = 0;
       int febn1 = 1;
       int feb = febn0+febn1;
       for ( int i = 2; i <= n; i++)
       {
           feb = febn0 + febn1;
           febn0 = febn1;
           febn1 = feb;
       }
        return feb;
    }

    public static int fiborecursive(int n)
    {
        if ( n == 0 )
            return 0;
        if ( n == 1 )
            return 1;
        return(fiborecursive(n-1) + fiborecursive(n-2));
    }
}
