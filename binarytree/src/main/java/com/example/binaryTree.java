package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/* solutions for binary tree by Jung Verheiden */
public class binaryTree
{
    class Node
    {
        int id;
        Node left;
        Node right;
        public  Node(int value)
        {
            id = value;
            left = null;
            right = null ;
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

        System.out.print("\n  Depth of the tree "  + brtree.depth());
        List<List<Integer>> result = brtree.verticalOrder();
        int level = 0;
        for ( List<Integer> list : result){
            System.out.print("\n  Level : " + level++);
            for(int id : list )
            {
                System.out.print( " " + id );
            }
        }

        System.out.println("A complete tree");
        brtree.display();
        brtree.delete(-111);
        brtree.delete(125);



        System.out.println("\nBinary tree after delete");
         brtree.display();

        result = brtree.verticalOrder();
        level = 0;
        for ( List<Integer> list : result){
            System.out.print("\n  Level : " + level++);
            for(int id : list )
            {
                System.out.print( " " + id );
            }
        }
        System.out.print("\n  Depth of the tree "  + brtree.depth());

        int[] ints = {1,1,4,0,0,1,2,1};
        if ( ifZeros(ints)  == true)
        {
            System.out.println("The array has zeros");
        }
        else
        {
            System.out.println("The array has not zeros");
        }
    }
    public  binaryTree()
    {
        root = null;
    }
    public void display() {
        traverseInOrder(root);
    }
    public void insert1(int value){
        Node newNode = new Node(value);
        if ( root == null ){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent  = current;
        while(true)
        {
            parent = current;
            boolean isLeft = false;
            if ( current.id > value )
            {
                current = current.left;
                if ( current == null )
                {
                    parent.left = newNode;
                    return;
                }
            }
            else if ( current.id < value )
            {
                current = current.right;
                if ( current == null )
                {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    public void insert(int value)
    {
        Node newNode = new Node(value);
        if ( root == null ) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = root;

        while (true )
        {
            parent = current;
            if ( current.id > value )
            {
                current = current.left;
                if ( current == null )
                {
                    parent.left = newNode;
                    return;
                }
            }
            else
            {
                current= current.right;
                if ( current== null )
                {
                    parent.right = newNode;
                    return;
                }
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
        return(Math.max( depthRecursive(node.left), depthRecursive(node.right)) +1 );
    }
    public Node findNode1(int value){
        if ( root == null )
            return null;

        Node current = root;
        while( current.id != value ){
            if ( value > current.id ){
                current = current.right;
            }
            else
            {
                current = current.left;
            }
            if ( current == null )
                return null;
        }
        return current;
    }
    public Node findNode(int value)
    {
        Node current = root;
        while( current.id != value )
        {
            if ( current.id < value )
                current = current.right;
            else
                current = current.left;
            if ( current == null )
                return null;
        }
        return current;
    }
    public void deleteNode1(int value){
        if ( root == null )
            return;
        if ( root.id == value)
            root = null;
        Node current = root;
        Node parent = current;
        boolean isLeft = false;

        while(current.id != value )
        {
            parent = current;
            if ( value > current.id )
            {
                current = current.right;
                isLeft = false;
            }
            else
            {
                current = current.left;
                isLeft = true;
            }
            if ( current == null )
                return;
        }
        if ( current.left == null && current.right == null ){
            if ( isLeft )
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
            return;
        }
        else if ( current.left == null )
        {
            if (isLeft)
            {
                parent.left = current.right;
            }
            else
            {
                parent.right  = current.right;
            }
            return;
        }else if ( current.right == null ){
            if ( isLeft )
                parent.left = current.left;
            else
                parent.right = current.left;
        }
        else if ( ( current.right != null ) && ( current.left != null )){
            Node successor = findSuccessor(current);
            if ( current == root ) {
                root = successor;
                return;
            }
            if ( isLeft )
                parent.left = successor;
            else
                parent.right = successor;
        }
    }
    public void deleteNode(int value)
    {
        if ( root == null )
            return ;
        if ( root.id ==  value )
        {
            root = null;
            return;
        }
        Node current = root;
        Node parent = current;
        boolean isLeft = false;
        while(current.id != value )
        {
            parent = current;
            if ( current.id < value )
            {
                current = current.left;
                isLeft = true;
            }
            else{
                current = current.right;
                isLeft = false;
            }
            if ( current == null )
                return;
        }
        if ( ( current.left == null ) && (current.right == null  ))
        {
            if ( isLeft )
                parent.left = null;
            else
                parent.right = null;
            return;
        }
        else if ( current.left == null )
        {
            if ( isLeft )
                parent.left = current.right;
            else
                parent.right = current.right;
            return;
        }
        else if ( current.right == null )
        {
            if ( isLeft )
                parent.left = current.left;
            else
                parent.right = current.left;
        }
        else if ( (current.right != null) && (current.left != null )){
            Node successor = findSuccessor(current);
            if ( current == root )
                root = successor;
            if ( isLeft )
                parent.left = successor;
            else
                parent.right = successor;
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

    private Node findSuccessor(Node deleteNode )
    {
        Node current = deleteNode.right;
        Node successor = null;
        Node parentSuccessor = null;
        while(current != null )
        {
            parentSuccessor = successor;
            successor = current;
            current = current.left;
        }
        if ( deleteNode.right != null  ) {
            parentSuccessor.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

    public List<List<Integer>>  verticalOrder()
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ( root == null )
            return result;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer,
                ArrayList<Integer>>();
        int minLevel = 0, maxLevel = 0;
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Integer> levelQ = new LinkedList<Integer>();
        queue.add(root);
        levelQ.add(0);
        while(!queue.isEmpty()){
            Node next = queue.poll();
            int level = levelQ.poll();
            minLevel = Math.min(minLevel, level );
            maxLevel = Math.max(maxLevel, level );

            if (map.containsKey(level))
            {
                map.get(level).add(next.id);
            }
            else
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(next.id);
                map.put(level, list);
            }
            if ( next.left != null ){
                queue.offer(next.left);
                levelQ.offer(level - 1);
            }
            if ( next.right != null ){
                queue.offer(next.right);
                levelQ.offer(level+1);
            }
        }
        for(int i = minLevel; i <= maxLevel; i++){
            if( map.containsKey(i))
                result.add(map.get(i));
        }
        return result;
    }

    public void delete(int value){
        if ( root == null ){
            return;
        }
        Node current = root;
        Node parent = null;
        boolean isLeft = false;
        while( current.id != value ) {
            parent = current;
            if (current.id < value) {
                current = current.right;
                isLeft = false;
            } else {
                current = current.left;
                isLeft = true;
            }
            if (current == null)
                return;
        }
        if ( ( current.left == null ) &&
            ( current.right == null ))
        {
            if ( current == root )
                root = null;
           else if ( isLeft )
               parent.left = null;
            else
               parent.right = null;
            return;
        }else if ( current.left == null ) {
            if ( current == root )
                root = current.right;
            else if ( isLeft )
                parent.left = current.right;
            else
                parent.right = current.right;
            return;
        }
        else if ( current.right == null )
        {
            if ( isLeft )
                parent.left = current.left;
            else
                parent.right = current.left;
        }else if (( current.left != null ) && ( current.right != null )){
            Node successor = getSuccessor(current );
            if ( current == root )
                root = successor;
            else if ( isLeft )
                parent.left = successor;
            else
                parent.right = successor;
        }
    }

    public Node getSuccessor(Node deleteNode)
    {
          Node successor = null;
          Node parentSuccessor = null;
          Node current = deleteNode.right;
          while ( current != null  )
          {
              parentSuccessor = successor;
              successor = current;
              current = current.left;
          }
          if ( deleteNode.right != successor ) {
              parentSuccessor.left = successor.right;
              successor.right = deleteNode.right;
          }
        return successor;
    }
    public int maxDepth(Node oneNode)
    {
        if ( oneNode == null )
            return 0;
        return( Math.max( maxDepth( oneNode.left ), maxDepth(oneNode.right)) + 1);
    }
    public void traverseInOrder(Node currentNode)
    {
        if ( currentNode == null )
            return;
        if ( currentNode.left != null )
        {
            traverseInOrder(currentNode.left );
        }
        System.out.print("  " + currentNode.id );
        if ( currentNode.right != null )
           traverseInOrder(currentNode.right);
    }
}
