package com.example;

import java.util.ArrayList;
import java.util.List;

public class searchrange {
    ArrayList<Integer> res;
    static public void main(String[] args )
    {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(1);
        ArrayList<Integer> output =  new searchrange().searchRange(input, 1);
        System.out.println(output.get(0) + output.get(1));
    }
    public ArrayList<Integer> searchRange(final List<Integer> a, int target) {
        int low = 0;
        int high = a.size()-1;
        res = new ArrayList<Integer>();
        while(low <= high )
        {
            int mid = (low + high) /2;
            if ( target == a.get(mid) )
            {
                int start =mid -1;
                while( ( start >= low )&& (a.get(start) == target) )
                {
                    start--;
                }
                start = start + 1;
                int end = mid + 1;
                while( ( end <= high) && (a.get(end) == target))
                {
                    end++;
                }
                end -= 1;
                for ( int i = start; i <= end; i++)
                {
                    res.add(i);
                }
                return(res);
            }
            else if ( target > a.get(mid) )
            {
                low = mid + 1;
            }
            else if ( target < a.get(mid))
            {
                high = mid -1;
            }
            if ( low == high )
            {
                res.add(-1);
                res.add(-1);
                return(res);
            }
        }
        return(res);
    }
}
