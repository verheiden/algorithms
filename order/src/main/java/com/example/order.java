package com.example;

import java.util.ArrayList;
import java.util.Collections;
/* the solution by Jung Verheiden for orderig heights using number of fronts */
public class order {
    static public void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<Integer>();
        heights.add(5);
        heights.add(3);
        heights.add(2);
        heights.add(6);
        heights.add(1);
        heights.add(4);

        ArrayList<Integer> orders = new ArrayList<Integer>();
        orders.add(0);
        orders.add(1);
        orders.add(2);
        orders.add(0);
        orders.add(3);
        orders.add(2);
        order obj = new order();
        ArrayList<Integer> ans = obj.order(heights, orders);
        for ( int i = 0; i < ans.size(); i++){
            System.out.print( " " + ans.get(i)+ " ");
        }
    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts)
    {
        ArrayList<pair> map = new ArrayList<pair>();
        ArrayList<Integer> orders = new ArrayList<Integer>();
        for ( int i = 0; i < heights.size(); i++)
        {
            map.add(new pair(heights.get(i), infronts.get(i)));
            orders.add(0);
        }
        Collections.sort(map);
        int n = heights.size();
        orderTbl tbl = new orderTbl(n);

        for ( int i = 0; i < infronts.size(); i++)
        {
            int res = tbl.getIth( map.get(i).infronts );
            orders.set( res, map.get(i).height );
        }
        return orders;
    }
    Node head;
    void initTree(int N)
    {
        head = new Node(0);

    }
    class Node {
        int data;
        int pri;
        int size;
        Node left;
        Node right;
        public Node(int val){
            data = val;

        }
    }
    public ArrayList<Integer> orderK(ArrayList<Integer> heights, ArrayList<Integer> infronts)
    {   
    ArrayList<pair> map = new ArrayList<pair>();
    ArrayList<Integer> orders = new ArrayList<Integer>();
    for ( int i = 0; i < heights.size(); i++)
    {
        map.add(new pair(heights.get(i), infronts.get(i)));
        orders.add(0);
    }
    Collections.sort(map);
    int n = heights.size();
    orderTbl tbl = new orderTbl(n);

    for ( int i = 0; i < infronts.size(); i++)
    {
        int res = tbl.getIth( map.get(i).infronts );
        orders.set( res, map.get(i).height );
    }
    return orders;
}
class orderTbl {
    int[] bits;
    int N;

    public orderTbl(int n) {
        N = n;
        bits = new int[N];
        for (int i = 0; i < N; i++) {
            bits[i] = 1;
        }
    }

    int getIth(int fronts) {
        int k = 0;
        for (int i = 0; i < N; i++) {
            if (bits[i] == 1) {
                if (k == fronts) {
                    bits[i] = 0;
                    return i;
                }
                k++;
            }
        }
        return k;
    }
}
    class pair implements Comparable<pair>
    {
        int infronts;
        int height;
        public pair (  int h , int order)
        {
            infronts = order;
            height = h;
        }
        @Override
        public int compareTo(pair b)
        {
            return height - b.height;
        }
    }
}
