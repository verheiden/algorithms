package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/* solutions for binary tree by Jung Verheiden */
public class binaryTree
{
    class Node {
        int id;
        Node left;
        Node right;

        public Node(int value){
           id = value;
           left = null;
           right = null;
        }
    }
    Node root;
    public static void  main (String[] args)
    {
        int[] intarray = new int[15];

         binaryTree  brtree = new binaryTree();
        brtree.insert(10);
        brtree.insert(2);
        brtree.insert(8);
        brtree.insert(4);
        brtree.insert(9);
        brtree.insert(7);
        brtree.insert(6);
        brtree.insert(5);
        brtree.insert(3);
        brtree.insert(-11);
        brtree.insert(-55);
        brtree.insert(-111);
        brtree.insert(125);
        brtree.insert(101);
        brtree.insert(-88);
        System.out.println("Complete tree");
        brtree.display();
        System.out.println("\n  Depth of the tree "  + brtree.depth());
        ArrayList<ArrayList<Integer>> result = brtree.verticalOrder();
        int level = 0;
        for ( ArrayList<Integer> list : result){
            System.out.print("\n  Level "  + level++ + " : ");
            for(int id : list )
            {
                System.out.print( " " + id );
            }
        }
        Node common = brtree.lCommonAncestor( 3, -11);
        if ( common != null )
            System.out.println("\nCommon ancestor of 3 & -11 : " + common.id);
        brtree.BFS();

        System.out.println("\nInorder Depth first traverse ");
        brtree.DFS(null);

        brtree.delete(-111);
        brtree.delete(125);
        brtree.delete(101);
        brtree.delete(2);
        brtree.delete(5);



        System.out.println("\nBinary tree after deleting -111 125 101 2 5");
         brtree.display();

        result = brtree.verticalOrder();
        level = 0;
        for ( ArrayList<Integer> list : result){
            System.out.print("\n  Level "  + level++ + " : ");
            for(int id : list )
            {
                System.out.print( " " + id );
            }
        }
        System.out.print("\n  Depth of the tree "  + brtree.depth());

        int[] ints = {1,1,4,0,0,1,2,1};
        if ( ifZeros(ints)  == true)
        {
            System.out.println("\nThe array has zeros");
        }
        else
        {
            System.out.println("\nThe array has not zeros");
        }
    }
    Node  lCommonAncestor(int A, int B)
    {
           if ( A > B ) return(findCommon(root, A, B));
           else
               return(findCommon(root, B, A));
    }
    public Node findCommon(Node parent, int big, int small)
    {
        if ( parent == null )
            return null;
        if ( parent.id <= big && parent.id >= small )
              return parent;
        if ( parent.id > big )
              return(findCommon(parent.left, big, small));
        else
            return(findCommon(parent.right, big, small));

    }

    public binaryTree() { root = null;}
    public void display() {
        traverseInOrder(root);
    }

   public void insert(int value){
        if ( root == null ){
            root = new Node(value);
            return;
        }
        Node current = root;
        while( current != null ){
            if ( value == current.id )
            {
                return;
            }
            else if ( value > current.id ){
                if( current.right == null )
                {
                    current.right = new Node(value);
                    return;
                }
                current = current.right;
            } else
            {
                if ( current.left == null ){
                    current.left = new Node(value);
                    return;
                }
                current = current.left;
            }
        }
   }

    public int depth()
    {
        return(depthRecursive(root));
    }

    public int depthRecursive(Node node)
    {
        if ( node == null )
            return 0;
        return(Math.max(depthRecursive(node.right), depthRecursive(node.left)) + 1);
    }
    public void BFS()
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
         System.out.print(node.id + " ");
         if ( node.left != null )
             q.add(node.left);
         if ( node.right != null )
             q.add(node.right);
        }
    }

    public void DFS(Node node)
    {
        traverseInOrder(root);
    }



    void delete(int val) {
        Node node = root;
        Node parent = null;
        Boolean parentLeft = false;
        while (node != null) {
            if (node.id == val)
                break;
            parent = node;
            if (node.id < val) {
                node = node.right;
                parentLeft = false;
            } else {
                node = node.left;
                parentLeft = true;
            }

        }
        if (node == null)
            return;
        if (parent == null) {
            root = null;
            return;
        }
        if (parentLeft == true) {
            if (node.right == null) {
                parent.left = node.left;
                return;
            } else if (node.left == null) {
                parent.left = node.right;
                return;
            } else {  // find the largest  Node on the Left Node and link the right child  to it.
                parent.left = node.left;
                Node rightChild = node.left.right;
                Node parentRight = node.left;
                while (rightChild != null) {
                    parentRight = rightChild;
                    rightChild = rightChild.right;
                }
                parentRight.right = node.right;
            }
        } else // right child of parent is deleted
        {
            if (node.left == null) {
                parent.right = node.right;
                return;
            } else if (node.right == null) {
                parent.right = node.left;
                return;
            } else // neither of the deleted childrent are null
            {
                parent.right = node.right;
                // find the smallest node of the right node
                Node leftChild = node.right.left;
                Node p = node.right;
                while (leftChild != null) {
                    p = leftChild;
                    leftChild = leftChild.left;
                }
                p.left = node.left;
            }
        }
    }

    public static boolean ifZeros(int[] list )
    {
        for(int n : list)
        {
            if ( n == 0 )
                return true;
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>>  verticalOrder()
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }
    
    void traverse(Node node, int level, ArrayList<ArrayList<Integer>> result)
    {
         if ( result.size() <= level )
         {
             ArrayList<Integer> row = new ArrayList<>();
             row.add(node.id);
             result.add(row);
         }
         else
         {
             result.get(level).add(node.id);
         }
         if ( node.left != null )
             traverse(node.left, level+1, result);
         if ( node.right != null )
             traverse(node.right, level+1, result);
    }



    public int maxDepth(Node oneNode)
    {
        if ( oneNode == null )
            return 0;
        return(Math.max(maxDepth(oneNode.left), maxDepth(oneNode.right)) + 1);
    }
    public void traverseInOrder(Node currentNode)
    {
        if ( currentNode == null )
            return;
        traverseInOrder(currentNode.left);
        System.out.print(currentNode.id + " ");
        traverseInOrder(currentNode.right);
    }
}
