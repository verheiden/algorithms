package com.example;

/*
** By Jung Verheiden, algorithm to compute a minmunm max number of book pages given to a person
*   if each person has to get at least one book given an array of a book sizes.
*/
import java.util.ArrayList;
import java.util.Arrays;

public class minMaxPages {
    int n ;
    int b;
    ArrayList<Integer> a;
    long totalPages;
    long average;
    static public void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        minMaxPages obj = new minMaxPages();
        a.add(27);
         a.add(97);
         a.add(26);
         a.add(12);
         a.add(67);
         a.add(10);
         a.add(33);
         a.add(79);
         a.add(49);
         a.add(79);
         a.add(21);
         a.add(67);
         a.add(72);
         a.add(93);
         a.add(36);
         a.add(85);
         a.add(45);
         a.add(28);
         a.add(91);
         a.add(94);
         a.add(57);
         a.add(1 );
        a.add(53);
         a.add(8 );
        a.add(44);
         a.add(68);
         a.add(90);
         a.add(24);

        int num = obj.books(a, 26);
    }
    public int books(ArrayList<Integer> a, int b) {
        n = a.size();
        this.b = b;
        this.a = a;
        totalPages = 0;
        if ( (a == null) || ( a.size() == 0 ))
            return -1;
        if ( a.size() < b )
              return -1;
        for(int pages: a){
            totalPages += pages;
        }
        average = totalPages/n;
        long ans = Integer.MAX_VALUE;
        long low = 0;
        long high = totalPages;
        while(low <= high)
        {
            long mid = (low+high)/2;
            if ( isPossible(mid) )
            {
                ans = mid;
                high = mid -1;
            }
            else
            {
                low = mid  + 1;
            }
        }
        return (int) ans;
    }

    boolean isPossible(long pages)
    {
        if ( pages < average ){
            return false;
        }
        long total = 0;
        int i;
        int iStudents = 1;
        for (  i = 0; i<n ;i++  )
        {
            if ( a.get(i) >  pages )
                return false;
            if ( total + a.get(i)  > pages )
            {
                iStudents++;
                total = a.get(i) ;
                if ( iStudents > b )
                {
                    return false;
                }
            }
            else
                total += a.get(i);
        }
        return true;
    }
}