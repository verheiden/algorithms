package com.example;

public class distNodes {
    public static void main(String[] args){
        int[]  numbers = new int[] { 3, 9,12, 45, 78, 123, 4,6, 99,128,17,1782,2789, 77,21};
        distNodes bTree = new distNodes();
        for ( int i = 0; i < numbers.length; i++){
            bTree.add(numbers[i]);
        }
        System.out.println("Nodes between :  " + bTree.distNodes(6, 2789));
    }
    Node root;
    class Node {
        int value;
        Node left;
        Node right;
        public Node(int val) {
            value = val;
            left = right = null;
        }
    }
    public distNodes()
    {
        root = null;
    }
    void add(int val){
        Node node = new Node(val);
        if ( root == null )
            root = node;
        else
            add(root, node );
    }

    void add(Node parent, Node node)
    {
        if ( parent.value > node.value )
        {
            if ( parent.left == null  )
            {
                parent.left = node;
                return;
            }
            else
            {
                add(parent.left, node);
            }
        }
        else if ( parent.value < node.value )
        {
            if ( parent.right == null )
                parent.right = node;
            else
                add(parent.right, node);
        }
    }

    int distNodes(int a, int b)
    {
        int n=0, m =0;
        Node parent  = findCommonAncestor(root, a, b);

        if ( a > b ) {
            if ( parent.value != a ) {
                n = findDistance(parent.right, a) + 1;
            }
            if ( parent.value != b )
                m = findDistance(parent.left, b) + 1;
        }
        else
        {
            if ( parent.value != a )
                 m = findDistance(parent.left, a) + 1;
            if (parent.value != b )
                n = findDistance(parent.right, b) +1;
        }
        return(n+m );
    }
    int findDistance(Node parent, int val){
        if ( parent == null  || parent.value == val )
            return 0;

        if ( parent.value <  val )
        {
            return( findDistance(parent.right, val) + 1 );
        }
        else if ( parent.value > val )
        {
            return(findDistance(parent.left, val) +1 );
        }
        return 0;
    }
    Node findCommonAncestor(Node parent, int a , int b)
    {
        if ( parent == null )
            return parent;

        if ( parent.value < a && parent.value < b )
        {
            return(findCommonAncestor(parent.right, a, b));
        }
        else if ( parent.value > a && parent.value > b )
        {
            return(findCommonAncestor(parent.left, a, b));
        }
        return parent;
    }
}
