package com.example;

import java.util.ArrayList;

/* solutions to find a minimum path to get to right and bottom corner of from
 * the left & top most corner by Jung Verheiden */

public class minimumPath {
    public static void main(String[] args){

    }
    ArrayList<ArrayList<Integer>> a;
    public int minimumTotal(ArrayList<ArrayList<Integer>> b) {
        long  sum = 0;
        int  col = 0;
        a = b;
        if (( a == null ))
            return 0;
        return( b.get(0).get(0) + lowestPath(1, 0));
    }
    int lowestPath(int rowIndex, int colIndex )
    {
        if ( rowIndex > (  a.size()  -1 ))
            return 0;
        ArrayList<Integer> row = a.get(rowIndex);
        if ( row.get(colIndex) < row.get(colIndex+1 ))
        {
            return(row.get(colIndex) + lowestPath(rowIndex+1, colIndex));
        }
        else if ( row.get(colIndex) > row.get(colIndex+1))
        {
            return( row.get(colIndex+1) + lowestPath(rowIndex+1, colIndex+1));
        }
        else
        {
            return (row.get(colIndex) +  Math.min( lowestPath(rowIndex+1, colIndex), lowestPath(rowIndex+1, colIndex+1)));
        }
    }
}
