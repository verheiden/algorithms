package com.example;

import java.util.ArrayList;
import java.util.Collections;
/* solutions for find out of height order of  people looking at the number of
 * smaller people in front  by Jung Verheiden */
public class HeightOrder {
    public static void main(String[] args)
    {
      ArrayList<Integer>  heights = new ArrayList<Integer>();
      ArrayList<Integer> infronts = new ArrayList<Integer>();
      heights.add(86);
        heights.add(92);
        heights.add(49);
        heights.add(21);
        heights.add(62);
        heights.add(27);
        heights.add(90);
        heights.add(59);


        infronts.add(2);
        infronts.add(0);
        infronts.add(0);
        infronts.add(2);
        infronts.add(0);
        infronts.add(2);
        infronts.add(1);
        infronts.add(3);
        HeightOrder obj = new HeightOrder();
        obj.order(heights, infronts);
    }
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

        ArrayList<People> line = new ArrayList<People>();
        ArrayList<Integer> orders = new ArrayList<Integer>();
        for ( int i = 0; i < heights.size(); i++ )
        {
            int height = heights.get(i);
            int infront = infronts.get(i);
            line.add( new People(height, infront));
            orders.add(0);

        }
        Collections.sort(line);
        secTree sTree = new secTree(infronts.size());

        for (int i = 0; i < line.size(); i ++ )
        {
            People shortest = line.get(i);
            int  order = sTree.getOrder(shortest.infronts+1 );
            orders.set(order, shortest.height);
        }
        return orders;
    }

    class secTree
    {
        int size ;
        int[] bits;
        public secTree(int n)
        {
            size = n;
            bits = new int[n+10];
            for ( int i = 1;  i <= size ; i++){
                update(i, 1);
            }
        }
        void update(int index, int value)
        {
            while(index >0 & index <= size )
            {
                bits[index] += value;
                index += (index & -index);
            }
            return;
        }
        int getOrder(int index)
        {
            int start = index;
            int end = size;
            int res = 0;
            int count = end - start + 1;

            while(count > 0 )
            {
                int mid = ( start + end )/2;

                int taller = query(mid);

                if ( taller < index )
                {
                    start = mid +1 ;
                }
                else if ( taller > index )
                {
                    end = mid - 1;
                }
                else if ( taller == index )
                {
                    res = mid;
                    end = mid -1;
                }
                count /= 2;
            }
            update(res, -1);
            return res - 1;
        }
        int query(int index)
        {
            int res= 0;
            while( index > 0 )
            {
                res += bits[index];
                index -= (index & -index );
            }
            return res;
        }
    }

    class People implements Comparable<People>
    {
        int height;
        int infronts;
        public People(int h, int front)
        {
            height = h;
            infronts = front;
        }

        @Override
        public int compareTo(People node)
        {
            return( Integer.compare(height, node.height));
        }
    }
}
