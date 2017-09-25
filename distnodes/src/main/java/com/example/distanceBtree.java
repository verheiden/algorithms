package com.example;

/*
** By Jung Verheiden, compute a number of nodes between two nodes within a binary tree.
*/
/**
 * Created by jung on 8/14/17.
 */

public class distanceBtree {
    public static void main(String[] args){
        int[]  numbers = new int[] { 3, 9,12, 45, 78, 123, 4,6, 99,128,17,1782,2789, 77,21};
        distanceBtree bTree = new distanceBtree();
        for ( int i = 0; i < numbers.length; i++){
            bTree.add(numbers[i]);
        }
        System.out.println("Nodes between :  " + bTree.distNodes(6, 2789));
    }
    Node root ;
    public distanceBtree(){
      root = null;
    }
    void add( int val){
        if ( root == null )
        {
            root = new Node(val);
        }
        else
        {
            root.add(val);
        }
    }
    int distNodes(int val1, int val2){
        int m,  n;
        Node comAncestor = commAncestor( root, val1, val2);
        m = findDist(comAncestor, val1);
        n = findDist(comAncestor, val2);
        return( m+n);
    }
    Node commAncestor(Node parent, int val1, int val2){
        if ( parent == null )
            return null;
        if ( val1 < parent.value && val2 < parent.value )
        {
            return( commAncestor(parent.left, val1, val2));
        }
        else if ( val1 > parent.value && val2 > parent.value )
            return( commAncestor(parent.right, val1, val2));
        return parent;
    }
    int findDist(Node parent, int  val)
    {
        if ( parent.value < val )
        {
            return( findDist(parent.right, val) + 1 );
        }
        else if (parent.value > val )
        {
            return( findDist(parent.left, val ) +1 );
        }
        return 0;
    }
    class Node
    {
        int value;
        Node left;
        Node right;
        public Node(int val){
            value = val;
            left = null;
            right = null;
        }

        public void add( int val){

           if ( val < value ){
               if ( right == null ){
                   right = new Node(val);
                   return;
               }
               else
               {
                   right.add( val);
               }
           }
           else
           {
               if ( left == null ){
                   left = new Node(val);
                   return;
               }
               else
                   left.add(val);
           }
        }
    }


}
