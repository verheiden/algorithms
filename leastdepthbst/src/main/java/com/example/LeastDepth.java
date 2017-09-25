package com.example;

/*
** By Jung Verheiden, given a series of integer numbers, build a binary tree that will
*   have a least depth of tree.
*/
import java.util.ArrayList;

public class LeastDepth {
    public static void main(String[] args){
        int[] A = new int[25];
        for ( int i = 0; i < 25; i++)
        {
            A[i] = i + 100;
        };
        LeastDepth obj = new LeastDepth(A);
        obj.test();

    }
    class Node
    {
        int val;
        Node left;
        Node right;
        public Node(int value)
        {
            val = value;
            left = right = null;
        }
    }
    Node root;
    int[] a;
    public LeastDepth(int[] b){
        root = null;
        a = b;
    }
    void test()
    {
        root = add(0, a.length -1 );
        System.out.println(findDepth(root));
    }
    Node add(int left, int right)
    {
        if ( left > right )
            return null;
        int mid = (left+right)/2;
        Node aNew = new Node(a[mid]);
        aNew.left = add(left, mid -1);
        aNew.right = add( mid +1, right);
        return aNew;
    }
    int findDepth(Node node)
    {
        if ( node  == null )
            return 0;
        return(1 + Math.max(findDepth(node.left), findDepth(node.right)));
    }
}
