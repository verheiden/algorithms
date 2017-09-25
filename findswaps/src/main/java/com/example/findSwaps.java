package com.example;

import java.util.ArrayList;

public class
/*
** By Jung Verheiden, find two nodes within a binary tree their position should be swapped.
*/
findSwaps {

    /**
     * Definition for binary tree  */
      class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           public TreeNode(int x) { val = x; left = null; right= null; }
       }

    public static void main(String[] args)
    {
        ArrayList ans = new findSwaps().testSwaps();
    }
    ArrayList<Integer>  testSwaps()
    {
        TreeNode  one = new TreeNode(1);
        TreeNode  two = new TreeNode(2);
        TreeNode  three = new TreeNode(3);
        one.left = two;
        one.right = three;
        return recoverTree(one);
    }

    public ArrayList<Integer> recoverTree(TreeNode a)
    {
        TreeNode node1 = null, node2 = null, tNode = null, first = null, second = null;
        TreeNode current = a;

        while( current != null )
        {
            if ( current.left == null ) {
                if (node1 == null) {
                    node1 = current;
                } else if (node2 == null) {
                    node2 = current;
                } else {
                    node1 = node2;
                    node2 = current;
                }
                current = current.right;
            }
            else {
                tNode = current.left;
                while ( tNode.right != null && ( tNode.right != current )) tNode = tNode.right;
                if ( tNode.right == null )
                {
                    tNode.right = current;
                    current =  current.left;
                    continue;
                }
                else
                {
                    tNode.right = null;
                    if ( node2 == null )
                        node2 = current;
                    else
                    {
                        node1 = node2;
                        node2 = current;
                    }
                    current = current.right;
                }
            }
            if ( (node1 != null && node2 != null ) && ( node1.val > node2.val)){
                if (first == null )
                    first = node1;
                second = node2;
            }

        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(Math.min(first.val, second.val));
        res.add(Math.max(first.val, second.val));
        return res;
    }
}
