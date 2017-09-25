package com.example;
/*
**by Jung Verheiden, Count minimum total numbers of candy if a higher rank gets more candies.
*/
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class candyCount
{
    static public void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        candyCount obj = new candyCount();
        System.out.println("Total number of candies  : " + obj.candy(a));
    }
    public int candy(ArrayList<Integer> ratings) {
        int N = ratings.size();
        ArrayList<pair> ratingsTable = new ArrayList<>();
        int[] candies = new int[N];
        int i;
        for ( i = 0; i < N; i++)
        {
            ratingsTable.add( new pair(ratings.get(i), i ));
        }
        Collections.sort(ratingsTable);
        Arrays.fill(candies, 0);
        int total = 0;
        for ( i = 0; i < N; i++)
        {
            int curCandy = 0;
            int rating = ratingsTable.get(i).ratings;
            int pos  = ratingsTable.get(i).index;
            if (( pos > 0 ) && ( rating > ratings.get(pos-1) ))
                curCandy = candies[pos-1];
            if ( pos < ( N-1 ) &&  rating > ratings.get(pos+1) )
                curCandy = Math.max( curCandy, candies[pos+1] );
            curCandy += 1;
            candies[pos] = curCandy;
            total+= curCandy;
        }
        return total;
    }

    public class pair implements Comparable<pair>
    {
        public int ratings;
        public int index;
        public pair( int rate, int in)
        {
            ratings = rate;
            index = in;
        }
        @Override
        public int compareTo(pair b )
        {
            return ( ratings - b.ratings );
        }
    }
}
