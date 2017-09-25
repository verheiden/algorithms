package com.example;

/*
** By Jung Verheiden, breath first search of binary tree.
*/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class gatherScore
{
    Node root;
    static public void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        gatherScore obj = new gatherScore();
        while(reader.hasNextInt()){
           obj.add(reader.nextInt());
        }
        System.out.println(obj.bfsScores());
    }
    class Node {
        int score;
        int count;
        Node left;
        Node right;

        public Node(int s)
        {
            score = s;
            count = 1;
            left = null;
            right = null;
        }
    }

    public gatherScore()
    {
      root = null;

    }
    String bfsScores()
    {
        List<Node>  queue = new LinkedList<>();
        StringBuffer sBuf = new StringBuffer();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove(0);
            if ( node != root )
                sBuf.append(',');
            if ( node != null )
            {
                sBuf.append( node.score+":"+node.count);
                if ( node.left == null && node.right == null )
                {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sBuf.toString();
    }
    private void add(int score)
    {
        if ( root == null )
        {
            root = new Node(score);
            return;
        }
        Node current = root;
        Node parent = root;

        while ( true  )
        {
            if ( current.score == score ){
                current.count++;
                return;
            }
            else if ( current.score < score ) {
                if (current.right == null) {
                    current.right = new Node(score);
                    return;
                }
                current = current.right;
            } else if ( current.score > score) {
                if ( current.left == null ){
                    current.left = new Node(score);
                    return;
                }
                current = current.left;
            }
        }

    }
}
