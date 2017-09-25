package com.example;
/* solutions to determins minimum time to paint all the boards by a number of
   painters by Jung Verheiden */
import java.util.ArrayList;

public class facebookPaint {
    final static long MOD = 10000003;
    public static void main(String[] args){
        facebookPaint obj = new facebookPaint();
        ArrayList<Integer>  boards = new ArrayList<Integer>();
        boards.add(1000000);
        boards.add(1000000);

        System.out.println(obj.paint(1, 1000000,boards ));
    }
    public int paint1(int painters, int time, ArrayList<Integer> bSizes){
        long high =0, low, mid, total=0, largest = 0;
        for( int i = 0; i < bSizes.size(); i++){
            int bSize = bSizes.get(i);
            if ( bSize > largest )
                largest = bSize;
            high += bSizes.get(i)*time;
        }
        low = largest * time;
        while( low <= high)
        {
            mid = (low+high)/2;
            if ( isPossible(painters, time, bSizes, mid))
            {
                total = mid;
                high = mid  -1;
            }
            else
            {
                low = mid +1;
            }
        }
        return( (int) (total%MOD));

    }
    private boolean isPossible1(int painters, int time, ArrayList<Integer> boards, long finishTime)
    {
        int n = boards.size();
        int index = 0;
        long total = 0;


        for( int i = 0;( i < painters && index < n ) ; i++ )
        {
            total = 0;
            while( index < n )
            {
                total += boards.get(index)*time;
                if ( total > finishTime)
                    break;
                index++;
            }
        }
        if ( index == n )
            return true;
        else
            return false;
    }
    public int paint(int painters, int time, ArrayList<Integer> boards)
    {

        long   high= 0;
        long largest = 0;
        for ( int i = 0; i < boards.size(); i++)
        {
            if ( boards.get(i) > largest)
                largest =  boards.get(i);
            high += (long) boards.get(i)*time;
        }
        long   low =  largest*time;
        long   total = 0;
        long   mid ;

        while(low <= high )
        {
            mid =  (low + high)/2;

            if ( isPossible(painters, time, boards, mid) )
            {
                total = mid;
                high = mid -1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return((int)(total%MOD));
    }

    boolean isPossible(int painters, int time, ArrayList<Integer> boards, double  finishTime)
    {
        double  total = 0;
        int n = boards.size();
        int index = 0;
        for ( int i = 0; ( i < painters )& (index < n); i++ )
        {
            total = 0;
            while( index < n )
            {
                total += (double )boards.get(index)*time;
                if ( total > finishTime )
                {
                    break;
                }
                index++;
            }
        }
        if ((index == n ) )
            return true;
        else
            return false;
    }
}
