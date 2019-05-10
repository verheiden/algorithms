package com.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jung on 1/18/16.
 */
public class Node
{
    public Node[] child;
    String vertex;
    public State state;
    int childCount;

    public Node(String v, int c)
    {
        vertex = v;
        childCount = 0;
        state = State.Unvisited;
        child = new Node[c];
    }

    public void addChildNode(Node adj)
    {
        if (childCount < child.length )
        {
            child[childCount] = adj;
            childCount++;
        }
    }

    public Node[] getChild()
    {
        return child;
    }

    public String getVertex()
    {
        return vertex;
    }
}
