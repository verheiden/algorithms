package com.example;

import java.util.ArrayList;
/*
**by Jung Verheiden, given a matrix and return antidignal array list
*/
public class antiDiagnal {
    static public void  main(String[] args){
        ArrayList<ArrayList<Integer>>  matrix = new ArrayList<>();
        for(int i = 1 ;i < 8; i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for( int j = 1; j < 8; j++){
                if ( j == (8 - i))
                {
                    row.add(j);
                }
                else
                {
                    row.add(0);
                }
            }
            matrix.add(row);
        }
        ArrayList<Integer> ans = antiDiagnal(matrix);
        for(Integer i : ans )
        {
            System.out.print( i + " ");
        }
    }
    public static ArrayList<Integer> antiDiagnal(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0)
            return  null;

        ArrayList<Integer> answer = new ArrayList<>();
        int n = a.size() -1;

        for (int i = 0; i <= n; i++) {
            answer.add( a.get(n -i ).get(i));
        }
        return answer;
    }
}
