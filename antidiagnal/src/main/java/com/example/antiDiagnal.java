package com.example;

import java.util.ArrayList;
/*
**by Jung Verheiden, given a matrix and return antidignal array list
*/
public class antiDiagnal {
    public ArrayList<ArrayList<Integer>> antiDiagnal(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0)
            return a;
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        int n = a.size();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                row.add(a.get(j).get(i - j));
            }
            answer.add(row);
        }
        for (int offset = 1; offset < n; offset++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            int y = 0;
            for (int x = n - 1; x >= offset; x--) {
                row.add(a.get(offset + y++).get(x));
            }
            answer.add(row);
        }
        return answer;
    }
}
