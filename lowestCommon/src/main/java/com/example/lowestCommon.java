package com.example;

/* Solution to find the lowest common ancestor of two nodes in a binaray tree by Jung Verheiden */
public class lowestCommon {
    static public void main(String[] args)
    {
        lowestCommon obj = new lowestCommon();
        obj.testLCA();
    }
    private void testLCA()
    {
         Node root = new Node(1);
         Node two = new Node(2);
         root.left = two;
         Node three = new Node(3);
         root.right = three;
         Node four = new Node(4);
         Node five = new Node(5);
         two.left = four;
         two.right = five;
         Node six = new Node(6);
         Node seven = new Node(7);
         three.left = six;
         three.right = seven;
         System.out.println(comAncestor( root,four, five ).val );
         System.out.println(comAncestor(root, four, six).val);
         System.out.println(comAncestor(root, three, four).val);
         System.out.println(comAncestor(root, two, four).val);
    }

    private  Node comAncestor(Node node, Node A, Node B)
    {
        if ( node == null )
            return null;
        if (( node.val == A.val) || ( node.val == B.val))
        {
            return node;
        }
        Node leftLCA = comAncestor(node.left, A, B);
        Node rightLCA = comAncestor(node.right, A, B);

        if ( (leftLCA != null ) && ( rightLCA != null ))
            return node;
         return( leftLCA != null ? leftLCA : rightLCA );
    }
    class Node {
        int val;
        Node left;
        Node right;
        public Node(int value)
        {
            val = value;
            left = null;
            right = null;
        }
    }
}
