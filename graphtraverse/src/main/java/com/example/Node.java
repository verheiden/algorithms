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
    public int childCount;
    private String vertex;
    public State state;

    public Node(String vertex)
    {
        this.vertex = vertex;
    }

    public Node(String vertex, int childlen)
    {
        this.vertex = vertex;
        childCount = 0;
        child = new Node[childlen];
        state = State.Unvisited;
    }

    public void addChildNode(Node adj)
    {
        adj.state = State.Unvisited;
        if(childCount < child.length)
        {
            this.child[childCount] = adj;
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
