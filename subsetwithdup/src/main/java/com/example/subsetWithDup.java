package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class subsetWithDup {
    ArrayList<ArrayList<Integer>> subsets;
    public static void main(String[] args){
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(5);
        B.add(4);
        subsetWithDup obj = new subsetWithDup();
        obj.subsetsWithDup(B);
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {

            Collections.sort(a);
            subsets = new ArrayList<>();

            buildSubset(a, new ArrayList<Integer>(), 0 );

            Collections.sort(subsets, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> a, List<Integer> b)
                {
                    int size = Math.min(a.size(), b.size());
                    for ( int i = 0; i < size; i++)
                    {
                        int cmp = Integer.compare(a.get(i), b.get(i));
                        if ( cmp != 0 )
                            return cmp;
                    }
                    return(Integer.compare(a.size(), b.size()));
                }
            });
            return subsets;
        }

    void buildSubset(ArrayList<Integer> a, ArrayList<Integer> mSet, int index)
    {
        if ( index >= a.size())
        {
            subsets.add(new ArrayList<Integer>(mSet));
            return;
        }
        int cIndex = index+1;

        while( (cIndex < a.size()) && ( a.get(cIndex) == a.get(index)))
            cIndex++;
        for ( int i = 0; i <= ( cIndex - index ); i++ )
        {
            for ( int j = 0; j < i; j++ )
            {
                mSet.add(a.get(index));
            }
            buildSubset(a, mSet, cIndex);

            for(int k = 0; k < i; k++ )
            {
                mSet.remove(mSet.size() - 1 );
            }
        }
    }
}

