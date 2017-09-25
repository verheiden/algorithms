package com.example;

/*
** By Jung Verheiden, algorithm to count number of swaps in order to put people
* in the ascending height order within the same age group, and put the teacher
* in the middle of two age group.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class numSwaps {

    static public void main(String[] args)
    {
        numSwaps obj = new numSwaps();
        obj.add(8, 120);
        obj.add(35, 180);
        obj.add(7,111);
        obj.add(8, 134);
        obj.add(7,98 );
        obj.add(7, 128);
        obj.add(8, 152);
        obj.add(8, 154);
        obj.add(8, 118);
        obj.add(7, 132);
        System.out.println(obj.countSwaps());
    }
    ArrayList<person>  seven;
    ArrayList<person>   eight;
    person teacher;
    int N;
    public class person  implements Comparable<person>
    {
        int age;
        int height;
        int order;
        public person(int height, int i)
        {
            this.height = height;
            order = i ;
        }
        @Override
        public int compareTo(person b)
        {
           return  height - b.height;
        }
    }
    public numSwaps()
    {
        seven = new ArrayList<>();
        eight = new ArrayList<>();
        N = 0;
    }

    void add(int age, int height)
    {
        if ( age == 7)
        {
            seven.add(new person(height, N));
        }
        else if ( age  == 8 )
        {
            eight.add(new person(height, N));
        }
        else
        {
            teacher = new person(height, N);
        }
        N++;
    }
    int countSwaps()
    {
        Collections.sort(seven);
        Collections.sort(eight, new Comparator<person>(){
            public int compare(person obj1, person  obj2 )
            {
                return(obj2.height - obj1.height );
            }
        });
        int total = 0;
        int i = 0;
        for( ; i < seven.size(); i++){
            total += Math.abs(i - seven.get(i).order);
        }
        total += Math.abs( i - teacher.order );

        for ( int k = 0; k < eight.size(); k++)
        {
            i++;
            total += Math.abs(i - eight.get(k).order);
        }
        return total;
    }

}
